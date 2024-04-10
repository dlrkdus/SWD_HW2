package com.example.helloworld.service;

import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {

    private Map<String, Performer> performers;

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

    public String makePerformance(String id) {
        String result = null;

        for (Map.Entry<String, Performer> entry : performers.entrySet()) { // lambda 로 하면 result 값 변경시 오류 남
            String performerId = entry.getKey();
            Performer performer = entry.getValue();

            if (performerId.equals(id)) { //파라미터 id와 performerId가 같으면
                result = performer.perform(); //공연 시작
                break;
            }
        }
        return result;
    }
}
