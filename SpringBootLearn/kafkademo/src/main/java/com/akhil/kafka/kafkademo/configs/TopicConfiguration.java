package com.akhil.kafka.kafkademo.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder.name("messagesTopic").build();
    }

}
