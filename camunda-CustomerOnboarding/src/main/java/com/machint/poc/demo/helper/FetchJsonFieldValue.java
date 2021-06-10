/**
 * 
 */
package com.machint.poc.demo.helper;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Parag Ranjan
 *
 */
public class FetchJsonFieldValue 
{
	public static String jsonFieldValue(String jsonStr, String key)
	{
		JSONObject json = new JSONObject(jsonStr);
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;
        String val = "";
        if (!exists) 
        {
            keys = json.keys();
            while (keys.hasNext()) 
            {
                nextKeys = (String) keys.next();
                try {
                    if (json.get(nextKeys) instanceof JSONObject) 
                    {
                        return jsonFieldValue(json.getJSONObject(nextKeys).toString(), key);
                    } 
                    else 
                    if (json.get(nextKeys) instanceof JSONArray) 
                    {
                        JSONArray jsonArray = json.getJSONArray(nextKeys);
                        int i = 0;
                        if (i < jsonArray.length()) 
                        	do 
                        	{
                        		String jsonArrayString = jsonArray.get(i).toString();
                        		JSONObject innerJson = new JSONObject(jsonArrayString);
                        		return jsonFieldValue(innerJson.toString(),key);
                        	} while (i < jsonArray.length());
                    }
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        } 
        else 
        {
            val = json.get(key).toString();
        }
        return val;
	}
}
