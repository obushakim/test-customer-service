package com.irfan.customer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfan.customer.dao.CustomerDAO;
import com.irfan.customer.dto.CustomerPayment;
import com.irfan.customer.entity.Customer;
import com.irfan.customer.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerDAO customerDao;

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Customer cust = customerDao.findById(id);

		return cust;
	}

	@Override
	public Customer getCustomerByCustNo(int custNo) {
		// TODO Auto-generated method stub
		Customer cust = customerDao.findByCustNo(custNo);

		return cust;
	}

	@Override
	public int updateCustomerBalance(CustomerPayment custPayment) {
		// TODO Auto-generated method stub
		try {
			Customer cust = customerDao.findByCustNo(custPayment.getCustNo());

			double substractedBal = cust.getBalance() - custPayment.getTotal_price();

			customerDao.updateCustomer(substractedBal, custPayment.getCustNo());

			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error(e.getMessage());
			return 0;
		}
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub\
		return customerDao.findAll();
	}

	@Override
	public int deleteCustomer(int id) {
		// TODO Auto-generated method stub
		int isDeleted = customerDao.deleteCustomer(id);

		return isDeleted;
	}
}
