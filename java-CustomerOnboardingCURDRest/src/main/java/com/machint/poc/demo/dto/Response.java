/**
 * 
 */
package com.machint.poc.demo.dto;

import java.util.Map;

import lombok.Data;

/**
 * @author Parag Ranjan
 *
 */
@Data
public class Response 
{
	private String statusCode;
	private String message;
	private Map<String, Object> result;
}
