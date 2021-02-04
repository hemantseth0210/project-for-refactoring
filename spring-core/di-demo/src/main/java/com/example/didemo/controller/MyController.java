package com.example.didemo.controller;

import com.example.didemo.service.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void hello(){
        //System.out.println("Hello !!");
        System.out.println(greetingService.sayGreeting());
    }
}
