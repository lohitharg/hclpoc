package com.bookstore.order.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bookstore.order.VO.User;
import com.bookstore.order.dto.UserRegistrationDto;



public interface PageServiceInterface extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
