package com.hw.kafka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CarsTravelDistanceCache {
    Logger logger = LoggerFactory.getLogger(CarsTravelDistanceCache.class.getName());

    private Map<String, CarTravellingData> carsTravelDistances;

    public CarsTravelDistanceCache() {
        this.carsTravelDistances = new HashMap<>();
    }

    public void updateCarPosition(CarPosition carPosition) {
        CarTravellingData carTravellingData = carsTravelDistances.get(carPosition.id());

        double traveledDistanceSincePreviousPoint = 0.0D;
        if (carTravellingData == null) {
            CarTravellingData travellingData = new CarTravellingData(carPosition.id(), new Coordinate(carPosition.x(), carPosition.y()));
            carsTravelDistances.put(carPosition.id(), travellingData);
            logger.info("The car " + carPosition.id() + " has traveled " + traveledDistanceSincePreviousPoint + " since the last point, the total travel distance is " + travellingData.getTotalDistance());
        } else {
            traveledDistanceSincePreviousPoint = carTravellingData.updatePositionAndDistance(new Coordinate(carPosition.x(), carPosition.y()));
            logger.info("The car " + carPosition.id() + " has traveled " + traveledDistanceSincePreviousPoint + " since the last point, the total travel distance is " + carTravellingData.getTotalDistance());
        }
    }

}
