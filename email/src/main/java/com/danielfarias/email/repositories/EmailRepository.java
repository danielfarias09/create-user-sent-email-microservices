package com.danielfarias.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfarias.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID>{

}
