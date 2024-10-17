package com.mybank.accounts.mapper;

import com.mybank.accounts.dto.AccountDto;
import com.mybank.accounts.entity.Account;

public class AccountsMapper {
	
	public static AccountDto mapToAccountDto(Account account,AccountDto accountDto)	{
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setBranchAddress(account.getBranchAddress());
		return accountDto;
	}
	
	public static Account mapToAccountEntity(AccountDto accountDto,Account accountEntity)	{
		accountEntity.setAccountNumber(accountDto.getAccountNumber());
		accountEntity.setAccountType(accountDto.getAccountType());
		accountEntity.setBranchAddress(accountDto.getBranchAddress());
		return accountEntity;
	}
}
