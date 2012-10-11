/**
 * 
 */
package com.ahura.places;

import java.util.Map;

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
	
	
	
	public JSonResponseHandler(final String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String doCallAndGetResponse(Map<String, String> urlParams) {
		String url = composeUrl(urlParams);
		
		// Open a socket with a stream reader
		// Read until the end and add to a builder
		// Return the read string
		
		throw new RuntimeException("Not implemented yet");
	}
	
	protected String composeUrl(Map<String, String> urlParams) {
		StringBuilder builder = new StringBuilder(); 
		builder.append(baseUrl);
		if (!baseUrl.endsWith("/")) {
			builder.append("/");
		}	
		builder.append(OUTPUT);
		
		boolean first = true;
		if (urlParams.size() > 0) {
			builder.append("?");
			for (Map.Entry<String, String> entry : urlParams.entrySet()){
				if (!first) {
					builder.append("&");
				} else {
					first = false;
				}
				builder.append(entry.getKey())
						.append("=")
						.append(entry.getValue());
			}
		}
		return builder.toString();
	}
	
}
