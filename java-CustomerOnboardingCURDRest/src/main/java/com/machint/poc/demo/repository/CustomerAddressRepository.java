package com.machint.poc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machint.poc.demo.model.CustomerAddress;

/**
 * @author Parag Ranjan
 *
 */
@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> 
{
	List<CustomerAddress> findByCustId(Integer custId);
	CustomerAddress findByCustIdAndAddressType(Integer custId, String addressType);
}
