package com.hw.kafka.model;

import java.util.LinkedList;
import java.util.List;

public class CarTravellingData {

   private String carId;
   private List<Coordinate> trackings;
   private Coordinate lastPosition;
   private double totalDistance;

    public CarTravellingData(String carId, Coordinate lastPosition) {
        this.carId = carId;
        this.totalDistance = 0;
        this.lastPosition = lastPosition;

        this.trackings = new LinkedList<>();
        this.trackings.add(lastPosition);
    }

    public double updatePositionAndDistance(Coordinate newPosition){
        trackings.add(newPosition);

        double ac = Math.abs(newPosition.y() - this.lastPosition.y());
        double cb = Math.abs(newPosition.x() - this.lastPosition.x());
        double distanceFromPreviousPosition = Math.hypot(ac, cb);
        this.totalDistance += distanceFromPreviousPosition;
        return distanceFromPreviousPosition;
    }

    public double getTotalDistance() {
        return this.totalDistance;
    }

}
