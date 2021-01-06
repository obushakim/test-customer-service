package com.irfan.customer.dto;

import java.util.Date;

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
public class CustomerPayment {
	private int id;
	private int trxNo;
	private int cartNo;
	private int custNo;
	private double total_price;
	private Date trxDate;
}
