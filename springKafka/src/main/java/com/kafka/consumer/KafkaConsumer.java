package com.kafka.consumer;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;


@Controller
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "#{'${kafka.first.topics}'.split(',')}",
            containerFactory = "${kafka.first.containerFactory}")
    public void listen(List<ConsumerRecord<String,String>> records,
                       Acknowledgment acknowledgment){

        try{
            for(ConsumerRecord<String,String> record:records){
                Optional<?> kafkaMessage = Optional.ofNullable(record.value());
                if(kafkaMessage.isPresent()) {
                    logger.info(JSON.toJSONString(record.key()));
                    logger.info(JSON.toJSONString(record.value()));
                }
            }
        }catch (Exception e){
            logger.error("kafka - exception,dataList is {}",e.getMessage());
            e.printStackTrace();
        }finally {
            //手动提交offset
            acknowledgment.acknowledge();
        }
    }
}
