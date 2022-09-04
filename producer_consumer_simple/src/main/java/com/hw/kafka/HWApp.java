package com.hw.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
public class HWApp {

    public static void main(String[] args) {
        SpringApplication.run(HWApp.class, args);
    }

//    @Bean
//    public MessageListener messageListener() {
//        return new MessageListener();
//    }
//
//    public static class MessageListener {
////
////        private CountDownLatch latch = new CountDownLatch(3);
////
////        private CountDownLatch partitionLatch = new CountDownLatch(2);
////
////        private CountDownLatch filterLatch = new CountDownLatch(2);
////
////        private CountDownLatch greetingLatch = new CountDownLatch(1);
//
//        @KafkaListener(topics = "${kafka.car-tracking.topic}", groupId = "foo", containerFactory = "fooKafkaListenerContainerFactory")
//        public void listenGroupFoo(String message) {
//            System.out.println("Received Message in group 'foo': " + message);
//        }
//
//        @KafkaListener(topics = "${kafka.car-tracking.topic}", groupId = "bar", containerFactory = "barKafkaListenerContainerFactory")
//        public void listenGroupBar(String message) {
//            System.out.println("Received Message in group 'bar': " + message);
//        }
//
////        @KafkaListener(topics = "${kafka.car-tracking.topic}", containerFactory = "headersKafkaListenerContainerFactory")
////        public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
////            System.out.println("Received Message: " + message + " from partition: " + partition);
////            latch.countDown();
////        }
////
////        @KafkaListener(topicPartitions = @TopicPartition(topic = "${partitioned.topic.name}", partitions = { "0", "3" }), containerFactory = "partitionsKafkaListenerContainerFactory")
////        public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
////            System.out.println("Received Message: " + message + " from partition: " + partition);
////            this.partitionLatch.countDown();
////        }
////
////        @KafkaListener(topics = "${filtered.topic.name}", containerFactory = "filterKafkaListenerContainerFactory")
////        public void listenWithFilter(String message) {
////            System.out.println("Received Message in filtered listener: " + message);
////            this.filterLatch.countDown();
////        }
////
////        @KafkaListener(topics = "${greeting.topic.name}", containerFactory = "greetingKafkaListenerContainerFactory")
////        public void greetingListener(Greeting greeting) {
////            System.out.println("Received greeting message: " + greeting);
////            this.greetingLatch.countDown();
////        }
//
//    }

}