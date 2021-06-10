/**
 * 
 */
package com.machint.poc.demo.service;

import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Parag Ranjan
 *
 */
@Service
public class CustomerService
{
	@Autowired
	private RuntimeService runtimeService;
	
	public void startProcess(String processDefinitionKey, Map<String, Object> requestDataMap) 
	{
		runtimeService.startProcessInstanceByKey(processDefinitionKey, requestDataMap);
	}

}
