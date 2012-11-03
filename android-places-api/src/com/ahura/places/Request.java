/**
 * 
 */
package com.ahura.places;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author pani
 *
 */
public class Request {

	private final Map<String, String> params = new HashMap<String, String>();
	
	public Request() {
	}

	public Request clear() {
		params.clear();
		return this;
	}

	public Set<Entry<String, String>> entrySet() {
		return params.entrySet();
	}

	public Request put(String key, String value) {
		params.put(key, value);
		return this;
	}

	public String get(Object key) {
		return params.get(key);
	}
	
	public int size() {
		return params.size();
	}
 
}
