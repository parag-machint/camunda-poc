/**
 * 
 */
package com.machint.poc.demo.dto;

import lombok.Data;

/**
 * @author Parag Ranjan
 *
 */
@Data
public class CustomerAddressDTO 
{
	private Integer custAddressId;
	private Integer custId;
	private String addressType;
	private String houseNumber;
	private String street;
	private String zipCode;
	private String city;
	private String district;
	private String state;
	private String country;
}
