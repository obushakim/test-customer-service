package com.irfan.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "cust_no", nullable = false)
	private int custNo;

	@Column(name = "fullname", nullable = false)
	private String fullName;

	@Column(name = "balance")
	private double balance;

	@Column(name = "address", nullable = false)
	private String address;
}
