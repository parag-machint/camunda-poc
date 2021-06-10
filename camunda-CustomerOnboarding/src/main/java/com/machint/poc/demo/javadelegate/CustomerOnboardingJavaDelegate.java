/**
 * 
 */
package com.machint.poc.demo.javadelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.machint.poc.demo.dto.CustomerAddressDTO;
import com.machint.poc.demo.dto.CustomerDTO;
import com.machint.poc.demo.dto.RequestDTO;
import com.machint.poc.demo.dto.RequestDataDTO;
import com.machint.poc.demo.helper.ConversionJsonArrayToMap;
import com.machint.poc.demo.helper.ConversionJsonToMap;
import com.machint.poc.demo.helper.ConversionListMapToListObject;
import com.machint.poc.demo.helper.ConversionMapToObject;
import com.machint.poc.demo.helper.ConversionObjectToJson;
import com.machint.poc.demo.helper.FetchJsonFieldValue;

/**
 * @author Parag Ranjan
 *
 */
public class CustomerOnboardingJavaDelegate implements JavaDelegate 
{
	String requestJson;
	String checkExistingResponseJson;
	String stage;

	@Override
	public void execute(DelegateExecution execution) throws Exception 
	{
		requestJson=(String) execution.getVariable("requestJson");
		stage=(String) execution.getVariableLocal("stage");
		String jsonStringCustomer;
		String jsonStringCustomerResponse;
		String jsonStringCustomerAddress;
		Map<String, Object> mapCustomer;
		Map<String, Object> mapCustomerResponse;
		List<Map<String, Object>> mapCustomerAddress;
		CustomerDTO customerDto;
		CustomerDTO customerDtoResponse;
		List<CustomerAddressDTO> customerAddressDto;
		RequestDataDTO requestDataDto;
		RequestDTO requestDto;
		
		requestDto=new RequestDTO();
		requestDto.setRequestorId(FetchJsonFieldValue.jsonFieldValue(requestJson, "requestorId"));
		requestDto.setSource(FetchJsonFieldValue.jsonFieldValue(requestJson, "source"));
		
		switch (stage) 
		{
		case "CHECK_EXISTING":
			jsonStringCustomer=FetchJsonFieldValue.jsonFieldValue(requestJson, "customer");
			mapCustomer=ConversionJsonToMap.jsonToMap(jsonStringCustomer);
			customerDto=(CustomerDTO) ConversionMapToObject.mapToObject(mapCustomer, CustomerDTO.class);
			execution.setVariable("phNum", customerDto.getPhNum());
			break;
		case "INSERT":
			jsonStringCustomer=FetchJsonFieldValue.jsonFieldValue(requestJson, "customer");
			mapCustomer=ConversionJsonToMap.jsonToMap(jsonStringCustomer);
			customerDto=(CustomerDTO) ConversionMapToObject.mapToObject(mapCustomer, CustomerDTO.class);
			jsonStringCustomerAddress=FetchJsonFieldValue.jsonFieldValue(requestJson, "customerAddress");
			mapCustomerAddress=ConversionJsonArrayToMap.jsonArrayToMap(jsonStringCustomerAddress);
			customerAddressDto=new ArrayList<CustomerAddressDTO>();
			for(Object o:ConversionListMapToListObject.listMapToListObject(mapCustomerAddress, CustomerAddressDTO.class))
			{
				customerAddressDto.add((CustomerAddressDTO)o);
			}						
			requestDataDto=new RequestDataDTO();
			requestDataDto.setCustomer(customerDto);
			requestDataDto.setCustomerAddress(customerAddressDto);
			requestDto.setRequestData(requestDataDto);
			execution.setVariable("insertRequestJson", ConversionObjectToJson.objectToJson(requestDto));
			break;
		case "UPDATE":
			checkExistingResponseJson=(String)execution.getVariable("checkExistingResponseJson");
			jsonStringCustomerResponse=FetchJsonFieldValue.jsonFieldValue(checkExistingResponseJson, "customer");
			mapCustomerResponse=ConversionJsonToMap.jsonToMap(jsonStringCustomerResponse);
			customerDtoResponse=(CustomerDTO) ConversionMapToObject.mapToObject(mapCustomerResponse, CustomerDTO.class);
			
			jsonStringCustomer=FetchJsonFieldValue.jsonFieldValue(requestJson, "customer");
			mapCustomer=ConversionJsonToMap.jsonToMap(jsonStringCustomer);
			customerDto=(CustomerDTO) ConversionMapToObject.mapToObject(mapCustomer, CustomerDTO.class);
			customerDto.setCustId(customerDtoResponse.getCustId());
			jsonStringCustomerAddress=FetchJsonFieldValue.jsonFieldValue(requestJson, "customerAddress");
			mapCustomerAddress=ConversionJsonArrayToMap.jsonArrayToMap(jsonStringCustomerAddress);
			customerAddressDto=new ArrayList<CustomerAddressDTO>();
			for(Object o:ConversionListMapToListObject.listMapToListObject(mapCustomerAddress, CustomerAddressDTO.class))
			{
				
				customerAddressDto.add((CustomerAddressDTO)o);
			}
			for(CustomerAddressDTO x:customerAddressDto)
			{
				x.setCustId(customerDtoResponse.getCustId());
			}
			requestDataDto=new RequestDataDTO();
			requestDataDto.setCustomer(customerDto);
			requestDataDto.setCustomerAddress(customerAddressDto);
			requestDto.setRequestData(requestDataDto);
			execution.setVariable("updateRequestJson", ConversionObjectToJson.objectToJson(requestDto));
			execution.setVariable("custId", customerDto.getCustId());
			break;

		default:
			break;
		}
	}

}
