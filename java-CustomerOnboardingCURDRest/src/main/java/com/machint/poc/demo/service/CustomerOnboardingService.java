/**
 * 
 */
package com.machint.poc.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machint.poc.demo.model.Customer;
import com.machint.poc.demo.model.CustomerAddress;
import com.machint.poc.demo.repository.CustomerAddressRepository;
import com.machint.poc.demo.repository.CustomerRepository;

/**
 * @author Parag Ranjan
 *
 */

@Service
@Transactional
public class CustomerOnboardingService 
{
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CustomerAddressRepository customerAddressRepository;
	
    public Customer getCustomerByPhNum(String phNum) 
    {
        return customerRepository.findByPhNum(phNum);
    }
    
    public Customer getCustomerById(Integer custId) 
    {
        return customerRepository.findById(custId).get();
    }
    
    public Customer saveCustomer(Customer customer) 
    {
    	return customerRepository.save(customer);
    }
    
    public List<CustomerAddress> getCustomerAddressByCustId(Integer custId) 
    {
        return customerAddressRepository.findByCustId(custId);
    }
    
    public CustomerAddress getCustomerAddressByCustIdAndAddressType(Integer custId, String addressType) 
    {
        return customerAddressRepository.findByCustIdAndAddressType(custId,addressType);
    }
    
    public CustomerAddress getCustomerAddressById(Integer custAddressId) 
    {
        return customerAddressRepository.findById(custAddressId).get();
    }
    
    public List<CustomerAddress> saveCustomerAddress(List<CustomerAddress> customerAddress) 
    {
    	return customerAddressRepository.saveAll(customerAddress);
    }
}
