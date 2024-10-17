package com.mybank.accounts.mapper;

import com.mybank.accounts.dto.CustomerDto;
import com.mybank.accounts.entity.Customer;

public class CustomerMapper {

	public static Customer mapToCustomerEntity(CustomerDto customerDto,Customer entity)	{
		entity.setCustomerMobileNo(customerDto.getCustomerMobileNo());
		entity.setCustomerName(customerDto.getCustomerName());
		entity.setCustomerEmail(customerDto.getCustomerEmail());
		return entity;
	}
	
	public static CustomerDto mapToCustomerDto(Customer entity,CustomerDto dto)	{
		dto.setCustomerEmail(entity.getCustomerEmail());
		dto.setCustomerMobileNo(entity.getCustomerMobileNo());
		dto.setCustomerName(entity.getCustomerName());
		return dto;
	}
}
