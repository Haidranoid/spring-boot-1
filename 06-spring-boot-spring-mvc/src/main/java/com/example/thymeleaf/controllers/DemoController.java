package com.example.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;

@Controller
public class DemoController {
    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String showHello(Model model) {

        model.addAttribute("theDate", new Date());

        return "helloworld";
    }
}
