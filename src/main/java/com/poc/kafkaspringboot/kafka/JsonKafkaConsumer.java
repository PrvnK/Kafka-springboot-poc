package com.poc.kafkaspringboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.poc.kafkaspringboot.model.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "topicforjson", groupId = "myGroup")
	public User consumeMessage(User user) {
		LOGGER.info("Json message consumed by the kafka listener: {}", user.toString());
		return user;
	}
}
