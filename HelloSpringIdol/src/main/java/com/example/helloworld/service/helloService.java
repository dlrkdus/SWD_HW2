package com.example.helloworld.service;

import com.example.helloworld.config.MvcConfig;
import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;

@Service
public class helloService {

    @Autowired
    private helloService helloService;
    @Autowired
    private Map<String, Performer > perfMap;

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

    public String makePerformance(String id){
        Performer p=perfMap.get(id);
        return p.perform(); //perform String 타입으로 바꾸세요
    }
}
