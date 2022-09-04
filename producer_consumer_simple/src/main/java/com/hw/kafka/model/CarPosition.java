package com.hw.kafka.model;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notBlank;

public record CarPosition(String id, int x, int y) {

    public CarPosition(String id, int x, int y) {
        this.id = notBlank(id, "car id is required");
        isTrue(x > 0 , "x coordinate is required");
        this.x = x;
        isTrue(y > 0 , "y coordinate is required");
        this.y = y;
    }

}
