package com.redis.controller;

import com.alibaba.fastjson.JSON;
import com.mybatis.entities.User;
import com.redis.dao.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RedisController {

    @Autowired
    private UserRedis userRedis;

    @RequestMapping("/redis")
    @ResponseBody
    public String  insertRedis(){
        User user =new User();
        user.setId(1);
        user.setAge(2);
        user.setUserName("中文");
        user.setPassword("ppppp");
        userRedis.insertAsString("userRedis",user);
        return "ok";
    }
    @RequestMapping("/get")
    @ResponseBody
    public String  getRedis(){
        return userRedis.get("userRedis").getUserName();
    }

    @ResponseBody
    @RequestMapping("/hash")
    public String insertHash(){
        Map<String,String> userMap = new HashMap<String,String>();
        User user =new User();
        user.setId(1);
        user.setAge(2);
        user.setUserName("中文");
        user.setPassword("ppppp");
        String userJson = JSON.toJSONString(user);
        userMap.put("user",userJson);
         userRedis.insertAsHash("hash",userMap);
        return "ok";
    }
}
