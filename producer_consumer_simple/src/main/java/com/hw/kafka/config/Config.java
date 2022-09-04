package com.hw.kafka.config;

import com.hw.kafka.model.CarsTravelDistanceCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CarsTravelDistanceCache createCarsTravelDistanceCache() {
        return new CarsTravelDistanceCache();
    }

}
