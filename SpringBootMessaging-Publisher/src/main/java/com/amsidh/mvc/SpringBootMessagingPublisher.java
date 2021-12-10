package com.amsidh.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amsidh.mvc.domain.MessageBody;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
@RequiredArgsConstructor
public class SpringBootMessagingPublisher {

	private final MessageChannel output;

	@PostMapping("/publish")
	public MessageBody publishEvent(@RequestBody MessageBody messageBody) {
		output.send(MessageBuilder.withPayload(messageBody).build());
		return messageBody;

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMessagingPublisher.class, args);

	}

}
