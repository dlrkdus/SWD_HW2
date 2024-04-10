package com.example.helloworld.service;

import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {

    private final Map<String, Performer> performers;

    @Autowired
    public HelloService(Map<String, Performer> performers) {
        this.performers = performers;
    }

    public String getGreeting() {		// business method
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 10) {
            return "Good morning! ";
        } else if (hour >= 12 && hour <= 15) {
            return "Did you have lunch? ";
        } else if (hour >= 18 && hour <= 24) {
            return "Good evening! ";
        }
        return "Hello! ";
    }
}
