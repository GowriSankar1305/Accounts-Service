package com.mybank.accounts.service;

import com.mybank.accounts.dto.CustomerDto;

public interface AccountsService {
	void createAccount(CustomerDto customerDto);
	CustomerDto fetchAccount(String mobileNumber);
	boolean updateAccount(CustomerDto customerDto);
	boolean deleteAccount(String mobileNumber);
}
