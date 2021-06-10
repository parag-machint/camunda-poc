/**
 * 
 */
package com.machint.poc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Parag Ranjan
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer_address", schema="sandbox_java")
public class CustomerAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUST_ADDR_ID")
	private Integer custAddressId;
	
	@Column(name="CUST_ID")
	private Integer custId;
	
	@Column(name="ADDR_TYPE")
	private String addressType;
	
	@Column(name="HOUSE_NUM")
	private String houseNumber;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
}
