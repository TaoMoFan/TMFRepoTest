package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author taomofan
 * @Date 2021/1/29 2:05 下午
 * @Version 1.0
 */
@RestController
public class IndexController {
    @RequestMapping("index")
    public String index(){
        return "yes";
    }
}
