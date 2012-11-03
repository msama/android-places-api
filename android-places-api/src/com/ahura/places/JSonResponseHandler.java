/**
 * 
 */
package com.ahura.places;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Map;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Gets json data from a given url.
 * 
 * @author pani
 *
 */
public class JSonResponseHandler {

	private static final String TAG = "JsonResponse";

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
	public <T> T readJsonResponse(Request request, Type typeOfT)
			throws UnknownHostException, IOException {
		String json = readJsonResponse(request);
		Gson gson = new Gson();
		return (T) gson.fromJson(json, typeOfT);
	}
	
	public String readJsonResponse(Request request) throws IOException {
		String urlAddress = composeUrl(request);
		// create a URL
		// if url is null or not valid throw an exception
		URL url = new URL(urlAddress);
		
		// Open a socket with a stream reader
		Reader reader = null;
		try {
			reader = new InputStreamReader(url.openStream());
			return readJsonResponse(reader);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// pass
				}
			}
		}
	}
	
	public String readJsonResponse(Reader reader) throws IOException {
		// Read until the end and add to a builder
		// Return the read string
		StringBuilder builder = new StringBuilder();
		char[] buffer = new char[1024];
		int count = 0;
		while((count = reader.read(buffer)) != -1) {
			if (count > 0) {
				builder.append(buffer);
			}
		}
		return builder.toString();
	}
	
	protected String composeUrl(Request request) {
		StringBuilder builder = new StringBuilder(); 
		builder.append(baseUrl);
		builder.append("?key=")
				.append(key);
		
		// @see http://meyerweb.com/eric/tools/dencoder/
		for (Map.Entry<String, String> entry : request.entrySet()){
			try {
				builder.append("&")
					.append(URLEncoder.encode(entry.getKey(), "UTF-8"))
					.append("=")
					.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				Log.e(TAG, e.getMessage(), e);
			}
		}
		Log.d(TAG, builder.toString());
		return builder.toString();
	}
	
}
