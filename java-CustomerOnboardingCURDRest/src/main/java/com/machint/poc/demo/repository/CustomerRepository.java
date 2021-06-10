package com.machint.poc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machint.poc.demo.model.Customer;

/**
 * @author Parag Ranjan
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{
	
	Customer findByPhNum(String phNum);
}
