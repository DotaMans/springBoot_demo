package com.redis;


import com.redis.dao.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

    @Autowired
    private static UserRedis userRedis;

    public static void main(String[] args) {
         SpringApplication.run(RedisApplication.class, args);
    }
}
