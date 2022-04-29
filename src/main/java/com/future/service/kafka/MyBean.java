package com.future.service.kafka;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MyBean(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
