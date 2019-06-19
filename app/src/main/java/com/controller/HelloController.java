package com.controller;


import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){
        System.out.println("==============================");
        return "hello";
    }

    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        long zero = current/(1000*3600*24)*(1000*3600*24)
                - TimeZone.getDefault().getRawOffset()
                - (24*60*60*1000);
        System.out.println(zero);

    }
}
