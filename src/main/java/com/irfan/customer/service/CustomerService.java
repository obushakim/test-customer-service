package com.irfan.customer.service;

import java.util.List;

import com.irfan.customer.dto.CustomerPayment;
import com.irfan.customer.entity.Customer;

public interface CustomerService {
	public Customer getCustomer(int id);

	public Customer getCustomerByCustNo(int custNo);

	public List<Customer> getCustomers();

	public int updateCustomerBalance(CustomerPayment custPayment);

	public int deleteCustomer(int id);
}
