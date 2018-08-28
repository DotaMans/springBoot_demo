package com.redis.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mybatis.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void insertAsString(String key,  User user){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(user));
    }

    public String getStringValue(String key){
        return  redisTemplate.opsForValue().get(key);
    }

    public void insertAsList(String key, String value){
        redisTemplate.opsForList().leftPush(key,value);
    }

    public String getListValue(String key,Long index){
        return redisTemplate.opsForList().index(key,index);
    }

    public void insertAsHash(String key, Map<String,String> values){
        redisTemplate.opsForHash().putAll(key, values);
    }

    public Map<String,String> getMapValue(String key){
        HashOperations<String, String, String> hashOper = redisTemplate.opsForHash();
        return hashOper.entries(key);
    }

    public void insertAsSet(String key, String value){
        redisTemplate.opsForSet().add(value);
    }

    public Set<String> getSetValue(String key){
        return  redisTemplate.opsForSet().members(key);
    }

    public void setExpaireTime(String key, Long time){
        redisTemplate.expire(key,time, TimeUnit.SECONDS);
    }



    public User get(String key){
        String userJson = redisTemplate.opsForValue().get(key);
        return JSON.parseObject(userJson, new TypeReference<User>(){});
    }

    public List<User> getUsers(String key){
        String usersJson = redisTemplate.opsForValue().get(key);
        return  JSON.parseObject(usersJson, new TypeReference<List<User>>(){});
    }

    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }


}
