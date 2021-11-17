package com.dinesh.thinkme_clone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThinkMeApplication implements CommandLineRunner {
    @Value("${server.port}")
    private int port;

    private Logger logger = LoggerFactory.getLogger(ThinkMeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ThinkMeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Server Started on Port: " + port);
    }
}
