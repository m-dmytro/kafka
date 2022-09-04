package com.hw.kafka.controller;

import com.hw.kafka.model.CarPosition;
import com.hw.kafka.service.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PubController {
    Logger logger = LoggerFactory.getLogger(PubController.class.getName());

    @Autowired
    KafkaProducer producer;

    @PostMapping(value = "submit", consumes = "application/json", produces = "application/json")
    public void submit(@RequestBody CarPosition car) {

        logger.info("Message received at the endpoint: '" + car + "'");
        producer.sendMessage(car);
//        producer.sendMessage(car.id(), car.toString());

        System.out.println();
    }

}
