package com.ahura.places;

import java.util.HashMap;

import junit.framework.TestCase;

public class JSonResponseHandlerTestCase extends TestCase {

	final String baseUrl = "http://bar.foo";
	JSonResponseHandler handler;
	
	protected void setUp() throws Exception {
		super.setUp();
		handler = new JSonResponseHandler(baseUrl);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testComposeUrl_empty() {
		assertEquals(baseUrl + "/json" ,
				handler.composeUrl(new HashMap<String, String>()));
	}
	
	public void testComposeUrl_withParam() {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("fooK", "fooV");
		params.put("barK", "barV");
		
		assertEquals(baseUrl + "/json?barK=barV&fooK=fooV" ,
				handler.composeUrl(params));
	}

}
