package com.swag.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.swag.test.domain.Users;


@Component

public interface UserJPARepository extends JpaRepository<Users, Long>{

	Users findByName(String name);

}