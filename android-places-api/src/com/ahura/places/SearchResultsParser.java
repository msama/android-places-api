/**
 * 
 */
package com.ahura.places;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

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
	private final List<SearchResultsListener> list = new ArrayList<SearchResultsListener>();
	
	public boolean add(SearchResultsListener object) {
		return list.add(object);
	}

	public SearchResultsParser(String key) {
		responseHandler = new JSonResponseHandler(key, URL);
	}
	
	public void search(final Request request) {
		Thread th = new Thread() {
			@Override
			public void run() {
				SearchResult results = null;
				try {
					results = responseHandler.readJsonResponse(request, SearchResult.class);
				} catch (UnknownHostException e) {
					Log.e("SearchResultParser", e.getMessage());
					results = null;
				} catch (IOException e) {
					Log.e("SearchResultParser", e.getMessage());
					results = null;
				}
				for (SearchResultsListener listener: list){
					listener.onSearchResultFetched(results);
				}
			}
		};
		th.start();
		 
	}
	
}
