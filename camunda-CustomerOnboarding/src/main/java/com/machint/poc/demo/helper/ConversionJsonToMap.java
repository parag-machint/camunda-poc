/**
 * 
 */
package com.machint.poc.demo.helper;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Parag Ranjan
 *
 */
@SuppressWarnings("unchecked")
public class ConversionJsonToMap 
{
	public static ObjectMapper oMapper;
	public static Map<String, Object> jsonToMap(String jsonStr) throws JsonMappingException, JsonProcessingException
	{
		oMapper=new ObjectMapper();
		Map<String,Object> map = oMapper.readValue(jsonStr, Map.class);
		return map;
	}
}
