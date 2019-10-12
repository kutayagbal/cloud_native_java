package com.example.demo;

import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	private final JdbcTemplate jdbcTemplate;
	
	private final CustomerRepository customerRepo;

	public CustomerService(JdbcTemplate jdbcTemplate, CustomerRepository customerRepo) {
		this.jdbcTemplate = jdbcTemplate;
		this.customerRepo = customerRepo;
	}

	public Collection<Customer> findAll() {
		RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("ID"), rs.getString("EMAIL"));

		return this.jdbcTemplate.query("select * from CUSTOMER", rowMapper);
	}
	
	public void insertCustomers() {
		Stream.of("A", "B", "C").forEach(o -> customerRepo.save(new Customer(o)));
	}

}
