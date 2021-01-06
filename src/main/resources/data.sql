DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cust_no int NOT NULL,
  fullname VARCHAR(100) NOT NULL,
  balance DECIMAL(19,4) DEFAULT NULL,
  address VARCHAR(250) NOT NULL,
  created_date DATETIME DEFAULT NOT NULL,
  modified_date DATETIME DEFAULT NOT NULL
);

INSERT INTO customer (cust_no, fullname, balance, address, created_date, modified_date) VALUES
  (100001, 'Irfan Hakim', 1500500.1, 'jl. Sultan Hasanudin, Bekasi', '2020-12-24 00:00:00', '2020-12-24 04:03:00'),
  (100002, 'Obus', 1000000.1, 'Jl. Ahmad Yani, Bekasi', '2020-12-24 00:00:00', '2020-12-24 05:02:00');