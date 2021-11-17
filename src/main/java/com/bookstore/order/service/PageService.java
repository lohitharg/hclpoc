package com.bookstore.order.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookstore.order.VO.Role;
import com.bookstore.order.VO.User;
import com.bookstore.order.VO.UserData;
import com.bookstore.order.dto.UserRegistrationDto;
import com.bookstore.order.repository.UserRepository;



@Service
public class PageService implements PageServiceInterface{
	@Autowired
	private RestTemplate restTemplate;

	/*
	 * public ResponseEntity<UserData> getUserDetails() {
	 * System.out.println(restTemplate.exchange(
	 * "http://localhost:9090/getuserdetails", HttpMethod.GET, new
	 * HttpEntity<>(null), UserData.class)); ResponseEntity<UserData> userData =
	 * restTemplate.exchange("http://localhost:9090/getuserdetails", HttpMethod.GET,
	 * new HttpEntity<>(null), UserData.class); return userData;
	 */
	/*
	 * public String getUserDetails() {
	 * 
	 * System.out.println(restTemplate.exchange(
	 * "http://localhost:9090/getuserdetails", HttpMethod.GET, new
	 * HttpEntity<>(null), UserData.class));
	 * 
	 * 
	 * ResponseEntity<String> userData =
	 * restTemplate.exchange("http://localhost:9090/getuserdetails", HttpMethod.GET,
	 * new HttpEntity<>(null), String.class);
	 * 
	 * 
	 * String
	 * string=restTemplate.getForObject("http://localhost:9191/main/getuserdetails",
	 * String.class); System.out.println("String +++++++++))))))(((((((("+string);
	 * return string;
	 * 
	 * }
	 */

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public PageService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {

		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getAddress(),
				Arrays.asList(new Role("ROLE_USER")));

		/*
		 * User user = new User(); user.setFirstName(registrationDto.getFirstName());
		 * user.setLastName(registrationDto.getLastName());
		 * user.setEmail(registrationDto.getEmail());
		 * user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		 * user.setAddress(registrationDto.getAddress());
		 */

		return userRepository.save(user);

	}

	
	public User currentUserDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = findUserByUserName(auth.getName());
		System.out.println("User in auth"+user);
		return user;
		
	}

	public User findUserByUserName(String firstName) {
		return userRepository.findByEmail(firstName);
	}


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
