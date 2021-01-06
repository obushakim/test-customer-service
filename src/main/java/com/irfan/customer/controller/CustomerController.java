package com.irfan.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irfan.customer.dto.CustomerPayment;
import com.irfan.customer.entity.Customer;
import com.irfan.customer.service.CustomerService;

@RestController
public class CustomerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;

	@GetMapping("/")
	public String index() {

		return "Customer API";
	}

	@PutMapping(value = "/customers")
	public int updateCustomerBalance(@RequestBody CustomerPayment request) {
		int isUpdated = customerService.updateCustomerBalance(request);

		String msg = isUpdated > 0 ? "updated" : "not updated";
		LOGGER.info("customer is " + msg);

		return isUpdated;
	}

	@GetMapping(value = "/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();

		LOGGER.info(customers.toString());

		return customers;
	}

	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		int isDeleted = customerService.deleteCustomer(id);

		String msg = isDeleted > 0 ? "successfully deleted" : "unable to delete";

		return msg;
	}
}
