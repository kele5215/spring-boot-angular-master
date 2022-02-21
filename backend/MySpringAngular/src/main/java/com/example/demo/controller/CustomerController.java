package com.example.demo.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello my Springboot!";
	}

	@PostMapping
	public Customer post(@Validated @RequestBody Customer customer,Errors errors) {

		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}

		return customerService.register(customer);

	}



}
