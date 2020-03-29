package com.example.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bank.dao.CustomerRepository;
import com.example.Bank.entity.Customer;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	
	/*
	 * @Bean public CommandLineRunner demo(CustomerRepository repository) { return
	 * (args) -> { // save a few customers repository.save(new Customer("Prakash",
	 * 32, "Bangalore SV Symphony", "1234", 560055L, 400000L,
	 * "10/11/1987","abcd2")); repository.save(new Customer("Archana", 29,
	 * "Bangalore SV Symphony", "1235", 560055L, 1000000L, "10/11/1988","abcd1"));
	 * 
	 * // fetch all customers System.out.println("Customers found with findAll():");
	 * System.out.println("-------------------------------"); for (Customer customer
	 * : repository.findAll()) { System.out.println(customer.toString()); }
	 * System.out.println("");
	 * 
	 * // fetch all customer List<Customer> customer = (List<Customer>)
	 * repository.findAll(); System.out.println("All customer found");
	 * System.out.println("--------------------------------");
	 * System.out.println(customer.toString()); System.out.println("");
	 * 
	 * 
	 * }; }
	 */
}
