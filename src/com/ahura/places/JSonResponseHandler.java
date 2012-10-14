/**
 * 
 */
package com.ahura.places;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.Map;

import com.google.gson.Gson;

/**
 * Gets json data from a given url.
 * 
 * @author pani
 *
 */
public class JSonResponseHandler {

	// Output can be "json" or "xml". We only support json.
	private static final String OUTPUT = "json";
	
	private final String baseUrl;
	private final String key;
	
	public JSonResponseHandler(final String key, final String baseUrl) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null.");
		}
		this.key = key;
		
		if (baseUrl == null) {
			throw new IllegalArgumentException("Base Url cannot be null.");
		}
		
		StringBuilder builder = new StringBuilder(); 
		builder.append(baseUrl);
		
		// Add trailing slash
		if (!baseUrl.endsWith("/")) {
			builder.append("/");
		}
		
		// Add output format
		builder.append(OUTPUT);
		
		this.baseUrl = builder.toString();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T readJsonResponse(Map<String, String> urlParams, Type typeOfT)
			throws UnknownHostException, IOException {
		String json = readJsonResponse(urlParams);
		Gson gson = new Gson();
		return (T) gson.fromJson(json, typeOfT);
	}
	
	public String readJsonResponse(Map<String, String> urlParams)
			throws IOException, UnknownHostException {
		String urlAddress = composeUrl(urlParams);
		// create a URL
		// if url is null or not valid throw an exception
		
		// Open a socket with a stream reader
		// call readJsonResponse(InputStreamReader reader)
		throw new RuntimeException("Not implemented yet");
	}
	
	public String readJsonResponse(Reader reader) {
		// Read until the end and add to a builder
		// Return the read string
		throw new RuntimeException("Not implemented yet");		
	}
	
	protected String composeUrl(Map<String, String> urlParams) {
		StringBuilder builder = new StringBuilder(); 
		builder.append(baseUrl);
		builder.append("?key=")
				.append(key);
		
		for (Map.Entry<String, String> entry : urlParams.entrySet()){
			// TODO encode both key and value in base64
			builder.append(entry.getKey())
					.append("=")
					.append(entry.getValue());
		}
		return builder.toString();
	}
	
}
