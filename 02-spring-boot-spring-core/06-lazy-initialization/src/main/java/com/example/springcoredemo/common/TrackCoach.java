package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In construcotr: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "SRun a hard 5k!";
    }
}
