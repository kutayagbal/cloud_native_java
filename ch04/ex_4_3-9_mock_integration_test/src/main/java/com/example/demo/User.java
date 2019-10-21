package com.example.demo;

public class User {
	private Long userId;
	private String name;
	private Long accountId;

	public User(Long id, String name, Long accId) {
		this.userId = id;
		this.name = name;
		this.accountId = accId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
