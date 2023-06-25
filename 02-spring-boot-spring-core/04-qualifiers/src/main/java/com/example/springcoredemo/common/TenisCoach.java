package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
