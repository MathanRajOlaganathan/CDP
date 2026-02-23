package com.cdp.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CustomerServiceApplication.class);
        app.setApplicationStartup(new BufferingApplicationStartup(2048)); // Buffer the last 2048 steps
        app.run(args);
    }

}
