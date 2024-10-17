CREATE TABLE IF NOT EXISTS tbl_customer (
customer_id int auto_increment PRIMARY KEY,
cutomer_name VARCHAR(100) NOT NULL,
customer_email VARCHAR(100) NOT NULL,
customer_mobile_no VARCHAR(20) NOT NULL,
created_time date DEFAULT NULL,
created_by_whom VARCHAR(20) NOT NULL,
updated_time date DEFAULT NULL,
updated_by_whom VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS tbl_accounts (
customer_id int NOT NULL,
account_number int auto_increment PRIMARY KEY,
account_type VARCHAR(100) NOT NULL,
branch_address VARCHAR(200) NOT NULL,
created_time date NOT NULL,
created_by_whom VARCHAR(20) NOT NULL,
updated_time date DEFAULT NULL,
updated_by_whom VARCHAR(20) DEFAULT NULL
);