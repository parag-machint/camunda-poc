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
@Table(name="customer", schema="sandbox_java")
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUST_ID")
	private Integer custId;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PH_NUM")
	private String phNum;
}
