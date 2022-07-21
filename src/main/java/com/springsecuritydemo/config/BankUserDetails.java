package com.springsecuritydemo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritydemo.model.Customer;
import com.springsecuritydemo.model.SecurityCustomer;
import com.springsecuritydemo.repository.CustomerRepository;

@Service     // used with classes that provide some business functionalities //Spring context will auto detect these classes when annotation based configuration and classpath is being used 
public class BankUserDetails implements UserDetailsService {
	// requirement of only fetching data so UserDetails is implemented else UserDetailsManager
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   // will return UserDetails type object
		List<Customer> customer = customerRepository.findByEmail(username);   // search the database for the email
		if (customer.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		}
		return new SecurityCustomer(customer.get(0));
	}

}
