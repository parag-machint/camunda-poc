/**
 * 
 */
package com.machint.poc.demo.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Parag Ranjan
 *
 */
@SuppressWarnings("unchecked")
public class ConversionJsonArrayToMap 
{
	public static ObjectMapper oMapper;
	
	public static List<Map<String,Object>> jsonArrayToMap(String jsonArrayStr) throws JsonMappingException, JsonProcessingException
	{
		oMapper=new ObjectMapper();
		Object cropDetails = oMapper.readValue(jsonArrayStr, Object.class);
		List<Map<String, Object>> cropDetailsList = ((Collection<Map<String, Object>>) cropDetails).stream()
	            .map(eachCropJson->(HashMap<String, Object>) oMapper.convertValue(eachCropJson, HashMap.class))
	            .collect(Collectors.toList());
		return cropDetailsList;
	}
}
