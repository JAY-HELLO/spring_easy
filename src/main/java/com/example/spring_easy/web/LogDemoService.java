package com.example.spring_easy.web;

import com.example.spring_easy.commom.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    //private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
