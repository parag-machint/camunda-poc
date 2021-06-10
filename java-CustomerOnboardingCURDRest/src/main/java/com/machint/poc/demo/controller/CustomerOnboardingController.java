/**
 * 
 */
package com.machint.poc.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.machint.poc.demo.dto.CustomerAddressDTO;
import com.machint.poc.demo.dto.CustomerDTO;
import com.machint.poc.demo.dto.RequestDTO;
import com.machint.poc.demo.dto.RequestDataDTO;
import com.machint.poc.demo.dto.Response;
import com.machint.poc.demo.model.Customer;
import com.machint.poc.demo.model.CustomerAddress;
import com.machint.poc.demo.service.CustomerOnboardingService;

/**
 * @author Parag Ranjan
 *
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/customerOnboardingCURD")
public class CustomerOnboardingController 
{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerOnboardingService service;
	
	@GetMapping
	public ResponseEntity<Response> get(@RequestParam(name = "phNum") String phNum) 
	{
		Customer customer = service.getCustomerByPhNum(phNum);
		List<CustomerAddress> customerAddress;

		CustomerDTO customerDto;
		List<CustomerAddressDTO> customerAddressDto;
		
		Map<String, Object> result=new HashMap<String, Object>();
		Response response=new Response();
		
		
		if (customer != null) 
		{
			customerDto=modelMapper.map(customer, CustomerDTO.class);
			customerAddress=service.getCustomerAddressByCustId(customer.getCustId());
			if (customerAddress != null) 
			{
				customerAddressDto=customerAddress.stream().map(x -> modelMapper.map(x, CustomerAddressDTO.class))
						.collect(Collectors.toList());
				
				result.put("customer", customerDto);
				result.put("customerAddress",customerAddressDto);
				response.setStatusCode("200");
				response.setMessage("Success");
				response.setResult(result);

				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
			else
			{
				result.put("customer",customerDto);
				response.setStatusCode("200");
				response.setMessage("Success");
				response.setResult(result);
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
		}
		else
		{
			response.setStatusCode("404");
			response.setMessage("Not Found");
			return new ResponseEntity<Response> (response, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<Response> save(@RequestBody RequestDTO requestDto) 
	{
		
		Customer customerRequest = modelMapper.map(requestDto.getRequestData().getCustomer(), Customer.class);

		Customer customer = service.saveCustomer(customerRequest);

		CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);
		
		List<CustomerAddress> customerAddressRequest = requestDto.getRequestData().getCustomerAddress().stream().map(customerAddress -> modelMapper.map(customerAddress, CustomerAddress.class))
																	.collect(Collectors.toList());
		
		customerAddressRequest.forEach(i -> i.setCustId(customer.getCustId()));
		
		List<CustomerAddress> customerAddress = service.saveCustomerAddress(customerAddressRequest);

		List<CustomerAddressDTO> customerAddressResponse = customerAddress.stream().map(customerAddressDto -> modelMapper.map(customerAddressDto, CustomerAddressDTO.class))
																			.collect(Collectors.toList());
		
		Map<String, Object> result=new HashMap<String, Object>();
		Response response=new Response();
		
		result.put("customer",customerResponse);
		result.put("customerAddress",customerAddressResponse);
		response.setStatusCode("200");
		response.setMessage("Success");
		response.setResult(result);

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Response> update(@RequestParam(name = "custId")Integer custId,@RequestBody RequestDTO requestDto) 
	{
		
		Customer customerRequest = modelMapper.map(requestDto.getRequestData().getCustomer(), Customer.class);

		Customer customer = service.saveCustomer(customerRequest);

		CustomerDTO customerResponse = modelMapper.map(customer, CustomerDTO.class);
		
		List<CustomerAddress> customerAddressRequest = requestDto.getRequestData().getCustomerAddress().stream().map(customerAddress -> modelMapper.map(customerAddress, CustomerAddress.class))
																	.collect(Collectors.toList());
		
		customerAddressRequest.forEach(i -> i.setCustId(customer.getCustId()));
		
		List<CustomerAddress> customerAddress = service.saveCustomerAddress(customerAddressRequest);

		List<CustomerAddressDTO> customerAddressResponse = customerAddress.stream().map(customerAddressDto -> modelMapper.map(customerAddressDto, CustomerAddressDTO.class))
																			.collect(Collectors.toList());
		
		Map<String, Object> result=new HashMap<String, Object>();
		Response response=new Response();
		
		result.put("customer",customerResponse);
		result.put("customerAddress",customerAddressResponse);
		response.setStatusCode("200");
		response.setMessage("Success");
		response.setResult(result);

		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
}
