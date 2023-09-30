package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendEngine {
    public static void main(String[] args) {
        SpringApplication.run(BackendEngine.class, args);
        System.out.println("Backend is running...");
    }
}