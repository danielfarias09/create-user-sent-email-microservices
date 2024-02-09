package com.danielfarias.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.danielfarias.email.dtos.EmailRecordDto;
import com.danielfarias.email.models.EmailModel;
import com.danielfarias.email.services.EmailService;

@Component
public class EmailConsumer {
	
	private final EmailService emailService;
	
	public EmailConsumer(EmailService emailService) {
		this.emailService = emailService;
	}

	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailRecordDto emailDto) {
		var emailModel = new EmailModel();
		BeanUtils.copyProperties(emailDto, emailModel);
		this.emailService.sendEmail(emailModel);
	}

}
