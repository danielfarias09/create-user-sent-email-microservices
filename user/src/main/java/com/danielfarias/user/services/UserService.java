package com.danielfarias.user.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danielfarias.user.models.UserModel;
import com.danielfarias.user.producers.UserProducer;
import com.danielfarias.user.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	private final UserProducer userProducer;

	public UserService(UserRepository userRepository, UserProducer userProducer) {
		super();
		this.userRepository = userRepository;
		this.userProducer = userProducer;
	}


	@Transactional
	public UserModel save(UserModel user) {
		user = this.userRepository.save(user);
		this.userProducer.publishEmail(user);
		return user;
	}

}
