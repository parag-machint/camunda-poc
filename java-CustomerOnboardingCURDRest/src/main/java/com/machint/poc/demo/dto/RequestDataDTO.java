/**
 * 
 */
package com.machint.poc.demo.dto;

import java.util.List;

import lombok.Data;

/**
 * @author Parag Ranjan
 *
 */
@Data
public class RequestDataDTO
{
	private CustomerDTO customer;
	private List<CustomerAddressDTO> customerAddress;
}
