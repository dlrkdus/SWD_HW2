package com.example.helloworld.service;

import com.example.springidol.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {

    private final Map<String, Performer> performers;

    @Autowired
    public HelloService(Map<String, Performer> performers) {
        this.performers = performers;
    }
}
