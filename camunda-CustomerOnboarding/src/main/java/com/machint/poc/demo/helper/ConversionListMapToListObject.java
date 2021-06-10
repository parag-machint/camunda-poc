/**
 * 
 */
package com.machint.poc.demo.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author User
 *
 */
public class ConversionListMapToListObject 
{
	public static <T> List<Object> listMapToListObject(List<Map<String,Object>> listMap, Class<T> valueType)
	{
		List<Object> objectList=new ArrayList<Object>();
		listMap.forEach(map -> objectList.add((Object)ConversionMapToObject.mapToObject(map, valueType))); 
		return objectList;
	}
}
