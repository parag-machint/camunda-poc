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
public class RequestDTO 
{
	private String requestorId;
	private String source;
	private RequestDataDTO requestData;
}
