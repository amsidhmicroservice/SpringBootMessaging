package com.amsidh.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.amsidh.mvc.domain.MessageBody;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class SpringBootMessagingConsumer {

	@StreamListener("input")
	public void consumeMessage(MessageBody messageBody) {
		log.info("Consume payload: {}", messageBody);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMessagingConsumer.class, args);
	}

}
