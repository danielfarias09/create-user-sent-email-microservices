package com.danielfarias.email.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class RabbitMQConfig {
	
	@Value("${broker.queue.email.name}")
	private String queue;
	
	@Bean
	public Queue queue() {
		//true indica que a fila vai ser durável, ou seja, quando broker cair, a fila vai ser preservada
		return new Queue(queue, true);
	}
	
	@Bean//Converte a mensagem da fila de Json para o nosso DTO
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(mapper);
	}

}
