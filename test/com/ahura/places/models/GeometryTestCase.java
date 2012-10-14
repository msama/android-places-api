package com.ahura.places.models;

import com.google.gson.Gson;

import junit.framework.TestCase;

public class GeometryTestCase extends TestCase {
	
	public static final String GEOMETRY_JSON = 
			"{" +
               "\"location\" : " + LocationTestCase.LOCATION_JSON +
            "}";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGSon() {
		Gson gson = new Gson();
		Geometry geometry = gson.fromJson(GEOMETRY_JSON, Geometry.class);  
		assertNotNull(geometry);
		assertNotNull(geometry.getLocation());
	}

}
