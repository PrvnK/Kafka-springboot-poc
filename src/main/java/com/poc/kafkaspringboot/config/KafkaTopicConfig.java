package com.poc.kafkaspringboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name("kafkapoc").build();
	}
	
	@Bean
	public NewTopic createTopicForJsonMessage() {
		return TopicBuilder.name("topicforjson").build();
	}
}
