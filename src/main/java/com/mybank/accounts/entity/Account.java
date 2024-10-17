package com.mybank.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_accounts")
public class Account extends BaseEntity {
	@Id
	private Long accountNumber;
	private Long customerId;
	private String accountType;
	private String branchAddress;
}
