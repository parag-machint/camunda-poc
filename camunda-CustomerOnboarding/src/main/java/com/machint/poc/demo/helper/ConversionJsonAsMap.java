/**
 * 
 */
package com.machint.poc.demo.helper;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author User
 *
 */
public class ConversionJsonAsMap 
{
	public static Map<String,Object> jsonMap;
	
	public static Map<String, Object> JsonAsMap(String key, Object object) throws JsonProcessingException
	{
		String jsonStr = ConversionObjectToJson.objectToJson(object);
		
		jsonMap=new HashMap<String,Object>();
		
		jsonMap.put(key, jsonStr);
		
		return jsonMap;
	}
}
