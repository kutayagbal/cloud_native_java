package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	List<Account> findAccountsByUsername(String username);

	Account findAccountsByAccountNo(Long accountNo);
}
