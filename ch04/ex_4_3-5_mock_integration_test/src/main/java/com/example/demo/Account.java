package com.example.demo;

import javax.persistence.Entity;

@Entity
public class Account {
	private String accountName;
	private Long accountNo;

	public Account(String accountName, Long accountNo) {
		super();
		this.accountName = accountName;
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

}
