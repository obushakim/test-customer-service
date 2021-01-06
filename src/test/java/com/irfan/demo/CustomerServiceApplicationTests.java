package com.irfan.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.irfan.customer.dao.CustomerDAO;
import com.irfan.customer.entity.Customer;
import com.irfan.customer.service.CustomerService;
import com.irfan.customer.service.impl.CustomerServiceImpl;

@SpringBootTest
class CustomerServiceApplicationTests {

	@TestConfiguration
	static class CustomerServiceTestContextConfiguration {
		@Bean
		public CustomerService customerServTest() {
			return new CustomerServiceImpl();
		}
	}

	@Autowired
	CustomerService customerServTest;

	@MockBean
	private CustomerDAO customerDao;

//	@Test
	void contextLoads() {
		Customer cust = new Customer();
		cust.setId(1);
		cust.setFullName("Irfan");
		cust.setCustNo(100001);

		Mockito.when(customerDao.findByCustNo(cust.getCustNo())).thenReturn(cust);

		Customer customerr = customerServTest.getCustomerByCustNo(100001);
		Customer customer = customerDao.findByCustNo(100001);

		assertThat(customer.getFullName()).isEqualTo("Irfan");
	}

}
