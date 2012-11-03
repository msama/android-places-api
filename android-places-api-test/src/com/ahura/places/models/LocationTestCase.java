package com.ahura.places.models;

import com.google.gson.Gson;

import junit.framework.TestCase;

public class LocationTestCase extends TestCase {

	public static final String LOCATION_JSON = 
			"{" +
               "\"lat\" : -33.8750460," +
               "\"lng\" : 151.2052720" +
            "}";
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGSon() {
		Gson gson = new Gson();
		Location location = gson.fromJson(LOCATION_JSON, Location.class);  
		assertNotNull(location);
		assertEquals(-33.8750460, location.getLat());
		assertEquals(151.2052720, location.getLng());
	}
}
