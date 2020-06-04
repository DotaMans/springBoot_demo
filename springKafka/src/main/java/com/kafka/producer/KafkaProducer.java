package com.kafka.producer;

import com.alibaba.fastjson.JSON;
import com.kafka.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value("${kafka.topic")
    private String kafkaTopic;
    @RequestMapping("/send")
    public String send(){
        Message msg = new Message();
        msg.setId(15435L);
        msg.setMsg("hello");
        msg.setSendTime(new Date());
        kafkaTemplate.send(kafkaTopic, "fd");
        return "success";
    }
}
