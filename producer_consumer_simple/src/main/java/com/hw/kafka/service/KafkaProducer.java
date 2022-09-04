package com.hw.kafka.service;

import com.hw.kafka.model.CarPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {
    Logger logger = LoggerFactory.getLogger(KafkaProducer.class.getName());

    @Value("${kafka.car-tracking.topic}")
    private String topicName;

    @Autowired
    KafkaTemplate<String, CarPosition> carPositionKafkaTemplate;

    public void sendMessage(CarPosition carPosition) {
        ListenableFuture<SendResult<String, CarPosition>> future = carPositionKafkaTemplate.send(topicName, carPosition.id(), carPosition);
        future.addCallback(new ListenableFutureCallback<SendResult<String, CarPosition>>() {
            @Override
            public void onSuccess(SendResult<String, CarPosition> result) {
                logger.info("Sent message=[" + carPosition
                        + "] with: Topic: " + result.getRecordMetadata().topic()
                        + " Partition: " + result.getRecordMetadata().partition()
                        + " Offset: " + result.getRecordMetadata().offset()
                        + " Timestamp: " + result.getRecordMetadata().timestamp());
                System.out.println();
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message=[" + carPosition + "] due to : " + ex.getMessage());
            }
        });
    }



//    @Autowired
//    KafkaTemplate<String, String> kafkaTemplate;
//
//    public void sendMessage(String carId, String carPosition) {
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, carId, carPosition);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                logger.info("Sent message=[" + carPosition
//                        + "] with: Topic: " + result.getRecordMetadata().topic()
//                        + " Partition: " + result.getRecordMetadata().partition()
//                        + " Offset: " + result.getRecordMetadata().offset()
//                        + " Timestamp: " + result.getRecordMetadata().timestamp());
//                System.out.println();
//            }
//            @Override
//            public void onFailure(Throwable ex) {
//                logger.error("Unable to send message=[" + carPosition + "] due to : " + ex.getMessage());
//            }
//        });
//    }

}
