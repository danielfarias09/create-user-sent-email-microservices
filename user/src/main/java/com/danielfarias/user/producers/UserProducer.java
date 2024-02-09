package com.danielfarias.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.danielfarias.user.dtos.EmailDto;
import com.danielfarias.user.models.UserModel;

@Component
public class UserProducer {
	
	final RabbitTemplate rabbitTemplate;

	public UserProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Value("${broker.queue.email.name}") //Quando se usa o exchange default, a routing key tem que ser igual ao nome da fila
	private String routingKey;
	
	public void publishEmail(UserModel userModel) {
		var emailDto = new EmailDto();
		emailDto.setId(userModel.getId());
		emailDto.setEmailTo(userModel.getEmail());
		emailDto.setSubject("Cadastro realizado com sucesso!");
		emailDto.setText(userModel.getName() + ", seja bem vindo(a)! \n Agradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");
		
		//exchange, routingKey e DTO
		rabbitTemplate.convertAndSend("", routingKey, emailDto);		
	}
	
	

}
