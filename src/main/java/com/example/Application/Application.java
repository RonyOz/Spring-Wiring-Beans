package com.example.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private static final ApplicationContext context = new AnnotationConfigApplicationContext("com.example");

    public static ApplicationContext getContext() {
        return context;
    }
}