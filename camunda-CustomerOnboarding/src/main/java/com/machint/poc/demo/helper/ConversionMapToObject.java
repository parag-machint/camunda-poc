/**
 * 
 */
package com.machint.poc.demo.helper;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author User
 *
 */
public class ConversionMapToObject 
{
	public static ObjectMapper mapper;
	
	public static <T> Object mapToObject(Map<String,Object> map, Class<T> valueType)
	{
		mapper = new ObjectMapper();
		return mapper.convertValue(map, valueType);
	}
}
