package com.bookstore.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.order.VO.User;
import com.bookstore.order.VO.UserData;
import com.bookstore.order.service.PageService;

/**
 * @author Apurva Patel
 *
 */
@RestController
public class PageController {
	@Autowired
	private PageService pageService;
	@Autowired
	private RestTemplate restTemplate;

	/** this will get call on application startup **/

	@Autowired
	private PageService userService;

	private User user = new User();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");

		return modelAndView;

	}

	@RequestMapping(value = "/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(); // User user =
		User user = userService.currentUserDetails();
		modelAndView.addObject("userName", user.getFirstName());

		modelAndView.setViewName("index");
		return modelAndView;
	}

	/*
	 * @GetMapping("/") public String getHome() { return "poc deployed on azure";
	 * 
	 * }
	 */

	@RequestMapping("cart")
	public ModelAndView navigateToCartPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("cart");
		return modelAndView;
	}

	@RequestMapping("orderplaced")
	public ModelAndView navigateToOrderPlacedPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderplaced");
		return modelAndView;
	}

	@RequestMapping("orderlist")
	public ModelAndView navigateToOrderListPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderlist");
		return modelAndView;
	}
}
