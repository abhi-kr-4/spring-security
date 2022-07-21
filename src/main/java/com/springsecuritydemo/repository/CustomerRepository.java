package com.springsecuritydemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springsecuritydemo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {   // has a POJO class of customer which has a primary key of type long
	
	List<Customer> findByEmail(String email); // JPA will generate a SQL query with a where clause to find the customer list using email
      // return type will be a list of customer
}
