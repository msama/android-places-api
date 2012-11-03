package com.ahura.places.models;

import java.util.Arrays;

import com.google.gson.Gson;

import junit.framework.TestCase;

public class PlaceTestCase extends TestCase {
	
	
	
	public static final String PLACE_JSON = 
			"{" +
	           "\"formatted_address\" : \"529 Kent Street, Sydney NSW, Australia\"," +
               "\"geometry\" : " + GeometryTestCase.GEOMETRY_JSON + "," +
               "\"icon\" : \"http://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\","+
               "\"id\" : \"827f1ac561d72ec25897df088199315f7cbbc8ed\"," +
               "\"name\" : \"Tetsuya's\"," +
               "\"rating\" : 4.30," +
               "\"reference\" : \"CnRmAAAAmmm3dlSVT3E7rIvwQ0lHBA4sayvxWEc4nZaXSSjRtfKRGoYnfr3d5AvQGk4e0u3oOErXsIJwtd3Wck1Onyw6pCzr8swW4E7dZ6wP4dV6AsXPvodwdVyqHgyGE_K8DqSp5McW_nFcci_-1jXb5Phv-RIQTzv5BjIGS0ufgTslfC6dqBoU7tw8NKUDHg28bPJlL0vGVWVgbTg\"," +
               "\"types\" : [ \"restaurant\", \"food\", \"establishment\" ]" +
            "}";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGSon() {
		Gson gson = new Gson();
		Place place = gson.fromJson(PLACE_JSON, Place.class);  
		assertNotNull(place);
		assertEquals("529 Kent Street, Sydney NSW, Australia", place.getFormatted_address());
		assertNotNull(place.getGeometry());
		assertEquals("http://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png", place.getIcon());
		assertEquals("Tetsuya's", place.getName());
		assertEquals(4.30 , place.getRating());
		assertEquals("CnRmAAAAmmm3dlSVT3E7rIvwQ0lHBA4sayvxWEc4nZaXSSjRtfKRGoYnfr3d" +
				"5AvQGk4e0u3oOErXsIJwtd3Wck1Onyw6pCzr8swW4E7dZ6wP4dV6AsXPvodwdVyqHgyGE_K8D" +
				"qSp5McW_nFcci_-1jXb5Phv-RIQTzv5BjIGS0ufgTslfC6dqBoU7tw8NKUDHg28bPJlL0vGVWVgbTg"
				, place.getReference());
		
		String[] types = {"restaurant", "food", "establishment" };
		assertEquals(Arrays.toString(types), Arrays.toString(place.getTypes()));
		
	}

}
