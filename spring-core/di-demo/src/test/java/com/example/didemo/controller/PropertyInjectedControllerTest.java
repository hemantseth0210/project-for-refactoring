package com.example.didemo.controller;

import com.example.didemo.service.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyInjectedControllerTest {
    private PropertyInjectedController propertyInjectedController;

    @Before
    public void setUp() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    public void sayHello() {
        assertEquals(propertyInjectedController.sayHello(), GreetingServiceImpl.HELLO_GURUS);
    }
}