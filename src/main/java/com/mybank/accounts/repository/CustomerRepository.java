package com.mybank.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.accounts.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	 Optional<Customer> findByCustomerMobileNo(String mobileNumber);
}
