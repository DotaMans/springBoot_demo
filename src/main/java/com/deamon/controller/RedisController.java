package com.deamon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {

    @GetMapping("/")
    @ResponseBody
    public String test(){
        return "hello";
    }

}
