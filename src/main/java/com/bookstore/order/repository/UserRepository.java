package com.bookstore.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.order.VO.User;

	@Repository
	public interface UserRepository extends JpaRepository<User, Long>{
		User findByEmail(String email);
		User findByFirstName(String firstName);
	}

