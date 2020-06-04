package com.kafka.config;

import com.kafka.entities.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 从application.properties文件中加载对应的属性，映射到对象中
 */

@Configuration
public class KafkaPropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "kafka.first")
    public KafkaProperties kafkaFirstProperties(){return  new KafkaProperties();}


    @Bean
    @ConfigurationProperties(prefix = "kafka.second")
    public KafkaProperties kafkaSecondProperties(){return  new KafkaProperties();}
}
