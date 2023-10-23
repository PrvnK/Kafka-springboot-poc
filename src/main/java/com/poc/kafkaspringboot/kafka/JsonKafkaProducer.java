package com.poc.kafkaspringboot.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.poc.kafkaspringboot.model.User;

@Service
public class JsonKafkaProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	//in below KafkaTemplate definition, String, User denotes the datatypes of key and value.
	//Key(type:String), Value(type: User).
	private KafkaTemplate<String, User> kafkaTemplate;
	
	//when JAVA class contains only one parameterized constructor then @Autowired need not 
	//be used. So, for KafkaTemplate we didn't add @Autowired
	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user) {
		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "topicforjson")
				.build();
		//different impl of send method is used here in this example
		kafkaTemplate.send(message);
		LOGGER.info("Message sent: {}", user.toString());
	}
	
}
