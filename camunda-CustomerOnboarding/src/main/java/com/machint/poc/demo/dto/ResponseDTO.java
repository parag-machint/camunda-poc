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
public class ResponseDTO 
{
	private String statusCode;
	private String message;
	private List<Object> result;
}
