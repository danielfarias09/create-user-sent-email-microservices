package com.danielfarias.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfarias.user.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

}
