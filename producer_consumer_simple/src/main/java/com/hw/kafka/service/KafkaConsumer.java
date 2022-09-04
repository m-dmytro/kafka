package com.hw.kafka.service;

import com.hw.kafka.model.CarPosition;
import com.hw.kafka.model.CarsTravelDistancesCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class.getName());

    @Value("${kafka.car-tracking.topic}")
    private String topicName;

    @Value("${kafka.group.id}")
    private String groupId;

    @Autowired
    CarsTravelDistancesCache carsTravelDistancesCache;

    /** receive obj message from kafka */
    /** from all partitions in topic */
//    @KafkaListener(id = "${kafka.group.id}", topics = "${kafka.car-tracking.topic}", containerFactory = "carPositionKafkaListenerContainerFactory")
//    public void listen(@Payload CarPosition carPosition, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        logger.info("Received message=[" + carPosition + "] from:"
//                + " Topic: " + topicName
//                + " Partition: " + partition);
//    }

    /** from specific partition in topic */
    @KafkaListener(id = "car-position-consume-group_partition-0",
            topicPartitions = @TopicPartition(topic = "${kafka.car-tracking.topic}", partitions = { "0" }),
            containerFactory = "carPositionKafkaListenerContainerFactory")
    public void listenFromPartition0(@Payload CarPosition carPosition, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Received message=[" + carPosition + "] from: Topic: " + topicName + " Partition: " + partition);
        carsTravelDistancesCache.updateCarPosition(carPosition);
    }
    @KafkaListener(id = "car-position-consume-group_partition-1",
            topicPartitions = @TopicPartition(topic = "${kafka.car-tracking.topic}", partitions = { "1" }),
            containerFactory = "carPositionKafkaListenerContainerFactory")
    public void listenFromPartition1(@Payload CarPosition carPosition, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Received message=[" + carPosition + "] from: Topic: " + topicName + " Partition: " + partition);
        carsTravelDistancesCache.updateCarPosition(carPosition);
    }
    @KafkaListener(id = "car-position-consume-group_partition-2",
            topicPartitions = @TopicPartition(topic = "${kafka.car-tracking.topic}", partitions = { "2" }),
            containerFactory = "carPositionKafkaListenerContainerFactory")
    public void listenFromPartition2(@Payload CarPosition carPosition, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Received message=[" + carPosition + "] from: Topic: " + topicName + " Partition: " + partition);
        carsTravelDistancesCache.updateCarPosition(carPosition);
    }

//    /** receive string message from kafka */
//    @KafkaListener(id = "${kafka.group.id}", topics = "${kafka.car-tracking.topic}", containerFactory = "kafkaListenerContainerFactory")
//    public void listen(String data) {
//        System.out.println(data);
//    }
}
