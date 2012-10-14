/**
 * 
 */
package com.ahura.places;

import java.io.IOException;
import java.net.UnknownHostException;

import com.ahura.places.models.Place;
import com.ahura.places.models.SearchResult;

/**
 * Parses a search result json response and loads a
 * collection of {@link Place}.
 * 
 * 
 * @author pani
 * @see https://developers.google.com/places/documentation/search
 */
public class SearchResultsParser {

	private static final String URL = "https://maps.googleapis.com/maps/api/place/search/";
	private final JSonResponseHandler responseHandler;
	
	public SearchResultsParser(String key) {
		responseHandler = new JSonResponseHandler(key, URL);
	}
	
	public SearchResult search(Request request)
			throws UnknownHostException, IOException {
		return responseHandler.readJsonResponse(request, SearchResult.class);
	}
	
}
