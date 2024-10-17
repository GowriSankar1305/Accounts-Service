package com.mybank.accounts.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.mybank.accounts.constants.AccountsConstants;
import com.mybank.accounts.dto.AccountDto;
import com.mybank.accounts.dto.CustomerDto;
import com.mybank.accounts.entity.Account;
import com.mybank.accounts.entity.Customer;
import com.mybank.accounts.exception.CustomerAlreadyExistsException;
import com.mybank.accounts.exception.ResourceNotFoundException;
import com.mybank.accounts.mapper.AccountsMapper;
import com.mybank.accounts.mapper.CustomerMapper;
import com.mybank.accounts.repository.AccountRepository;
import com.mybank.accounts.repository.CustomerRepository;
import com.mybank.accounts.service.AccountsService;

@Service
public class AccountsServiceImpl implements AccountsService {

	private AccountRepository accountRepository;
	private CustomerRepository customerRepository;
	
	public AccountsServiceImpl(AccountRepository accountRepository,CustomerRepository customerRepository) {
		this.accountRepository = accountRepository;
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void createAccount(CustomerDto customerDto) {
		Customer customer = CustomerMapper.mapToCustomerEntity(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository.findByCustomerMobileNo(customerDto.getCustomerMobileNo() );
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    + customerDto.getCustomerMobileNo());
        }
		Customer savedCustomer = customerRepository.save(customer);
		accountRepository.save(createNewAccount(savedCustomer));
	}

	private Account createNewAccount(Customer customer) {
		Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress("oiuyrewertyuioiuytrewerty");
        return newAccount;
    }
	
	@Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByCustomerMobileNo(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountsMapper.mapToAccountDto(accounts, new AccountDto()));
        return customerDto;
    }
	
	 @Override
	    public boolean updateAccount(CustomerDto customerDto) {
	        boolean isUpdated = false;
	        AccountDto accountsDto = customerDto.getAccountDto();
	        if(accountsDto !=null ){
	            Account accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
	                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
	            );
	            AccountsMapper.mapToAccountEntity(accountsDto, accounts);
	            accounts = accountRepository.save(accounts);

	            Long customerId = accounts.getCustomerId();
	            Customer customer = customerRepository.findById(customerId).orElseThrow(
	                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
	            );
	            CustomerMapper.mapToCustomerEntity(customerDto, customer);
	            customerRepository.save(customer);
	            isUpdated = true;
	        }
	        return  isUpdated;
	    }
	 
	 @Override
	    public boolean deleteAccount(String mobileNumber) {
	        Customer customer = customerRepository.findByCustomerMobileNo(mobileNumber).orElseThrow(
	                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
	        );
	        accountRepository.deleteByCustomerId(customer.getCustomerId());
	        customerRepository.deleteById(customer.getCustomerId());
	        return true;
	    }
}
