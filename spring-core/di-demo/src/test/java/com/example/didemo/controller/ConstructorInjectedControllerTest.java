package com.example.didemo.controller;

import com.example.didemo.service.GreetingServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorInjectedControllerTest {
    private ConstructorInjectedController constructorInjectedController;

    @Before
    public void setUp() throws Exception {
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    public void sayHello() {
        assertEquals(constructorInjectedController.sayHello(), GreetingServiceImpl.HELLO_GURUS);
    }
}