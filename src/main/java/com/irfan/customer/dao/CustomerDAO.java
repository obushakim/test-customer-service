package com.irfan.customer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irfan.customer.entity.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
	public Customer findById(int id);

	@Query(value = "SELECT * FROM customer WHERE cust_no = ?1", nativeQuery = true)
	public Customer findByCustNo(int custNo);

	@Query(value = "SELECT * FROM customer", nativeQuery = true)
	public List<Customer> findAll();

	@Transactional
	@Modifying
	@Query(value = "UPDATE customer SET balance = :balance WHERE cust_no = :custNo", nativeQuery = true)
	public void updateCustomer(@Param("balance") double balance, @Param("custNo") int custNo);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM customer WHERE id = ?1", nativeQuery = true)
	public int deleteCustomer(int id);
}
