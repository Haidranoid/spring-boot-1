package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello world";
    }
    @GetMapping("/hi")
    public String helloWorld2(){
        return "Hello world adfasd 2";
    }
}
