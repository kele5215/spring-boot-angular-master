package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerMapper;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerMapper mapper;

	public CustomerServiceImpl(CustomerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Customer register(Customer customer) {

		String formattedEmail = formatEmail(customer.getEmail());
		customer.setEmail(formattedEmail);

		mapper.insert(customer);

		return customer;
	}

	private String formatEmail(String email) {
		String[] separatedEmail = email.split("@");

		return separatedEmail[0] + "@" + separatedEmail[1].toLowerCase();
	}

}
