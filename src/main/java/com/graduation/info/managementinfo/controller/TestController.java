package com.graduation.info.managementinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/test1")
    public String test1(){
        return "a+gg";
    }

    @GetMapping("/test3")
    public String test3(){
        return "test";
    }
}
