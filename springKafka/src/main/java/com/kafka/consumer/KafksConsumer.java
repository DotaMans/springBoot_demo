package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafksConsumer {

    @KafkaListener(topics = {"${spring.kafka.consumer.topic1}"})
    public void listen(ConsumerRecord<?,?> record){
        System.out.printf("topic = %s, offset = %d, value = %s \n");

    }
}
