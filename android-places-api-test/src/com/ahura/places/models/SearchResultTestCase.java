package com.ahura.places.models;

import java.util.Arrays;

import com.google.gson.Gson;

import junit.framework.TestCase;

public class SearchResultTestCase extends TestCase {
	
	public static final String SEARCH_RESULT_JSON = 
		"{" +
		   "\"html_attributions\" : [" +
		      "\"attribute\"" +
		   "]," +
		   "\"results\" : [" +
		   		PlaceTestCase.PLACE_JSON + "," +
		   		PlaceTestCase.PLACE_JSON + "," +
		   		PlaceTestCase.PLACE_JSON +
		   "]," +
		   "\"status\" : \"OK\"" +
		"}";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGSon() {
		Gson gson = new Gson();
		SearchResult searchResult = gson.fromJson(SEARCH_RESULT_JSON, SearchResult.class);  
		assertEquals(3, searchResult.getResults().length);
		
		String[] attributes = {"attribute"};
		assertEquals(Arrays.toString(attributes)
				, Arrays.toString(searchResult.getHtml_attributions()));
		
		assertEquals("OK", searchResult.getStatus());
	}


}
