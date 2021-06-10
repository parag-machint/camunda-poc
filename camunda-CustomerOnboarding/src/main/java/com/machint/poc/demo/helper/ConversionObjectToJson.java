/**
 * 
 */
package com.machint.poc.demo.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Parag Ranjan
 *
 */
public class ConversionObjectToJson 
{
	public static ObjectMapper oMapper;
	
	public static String objectToJson(Object object) throws JsonProcessingException
	{
		oMapper=new ObjectMapper();
		return oMapper.writeValueAsString(object);
	}
}
