package com.future;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class FutureApplication {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        log.info("hi {}, i have deploy on ecs!!", name);
        return String.format("hello %s", name);
    }

    public static void main(String[] args) {
        SpringApplication.run(FutureApplication.class);
    }

}
