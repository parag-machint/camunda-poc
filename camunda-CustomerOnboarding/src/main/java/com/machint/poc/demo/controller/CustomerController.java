/**
 * 
 */
package com.machint.poc.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.machint.poc.demo.dto.RequestDTO;
import com.machint.poc.demo.dto.ResponseDTO;
import com.machint.poc.demo.helper.ConversionJsonAsMap;
import com.machint.poc.demo.service.CustomerService;

/**
 * @author Parag Ranjan
 *
 */
@RestController
@RequestMapping("/api/customerOnboarding")
public class CustomerController 
{
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> save(@RequestBody RequestDTO requestDTO) throws IOException 
	{
		
		customerService.startProcess("customerOnboardingMain", ConversionJsonAsMap.JsonAsMap("requestJson", requestDTO));
		
		List<Object> result=new ArrayList<Object>();
		result.add(requestDTO.getRequestData());
		
		ResponseDTO responseDTO=new ResponseDTO();
		
		responseDTO.setStatusCode("200");
		responseDTO.setMessage("Process started successfully");
//		response.setResult(result);
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}
}
