package com.hw.kafka.config;

import com.hw.kafka.model.CarsTravelDistancesCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CarsTravelDistancesCache createCarsTravelDistanceCache() {
        return new CarsTravelDistancesCache();
    }

}
