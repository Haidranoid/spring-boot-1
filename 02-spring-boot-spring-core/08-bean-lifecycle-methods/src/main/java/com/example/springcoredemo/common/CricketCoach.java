package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In construcotr: " + this.getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void onInit(){
        System.out.println("In onInit(): " + this.getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void onDestroy(){
        System.out.println("In onDestroy(): " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
