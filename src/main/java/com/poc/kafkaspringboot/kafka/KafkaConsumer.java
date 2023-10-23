package com.poc.kafkaspringboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "kafkapoc", groupId = "myGroup")
	public void consume(String message) {
		LOGGER.info("Message consumed by the kafka listener: {}", message);
	}
}
