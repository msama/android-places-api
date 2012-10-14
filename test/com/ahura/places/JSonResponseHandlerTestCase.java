package com.ahura.places;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.UnknownHostException;

import junit.framework.TestCase;

public class JSonResponseHandlerTestCase extends TestCase {

	final String baseUrl = "http://bar.foo";
	final String key = "the_key";
	JSonResponseHandler handler;
	
	protected void setUp() throws Exception {
		super.setUp();
		handler = new JSonResponseHandler(baseUrl, key);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConstructor_addTrailingSlash() {
		fail("Not implemented yet");
	}
	
	public void testConstructor_addOutput() {
		fail("Not implemented yet");
	}
	
	public void testComposeUrl_empty() {
		assertEquals(baseUrl + "/json" ,
				handler.composeUrl(new Request()));
	}
	
	public void testComposeUrl_base64() {
		fail("Not implemented yet");
	}
	
	public void testComposeUrl_withParam() {
		Request params = new Request()
				.put("fooK", "fooV")
				.put("barK", "barV");
		
		assertEquals(baseUrl + "/json?barK=barV&fooK=fooV" ,
				handler.composeUrl(params));
	}
	
	public void testRreadJsonResponse_invalidUrlThrowsAnException() {
		try {
			handler = new JSonResponseHandler("not a url string", key);
			handler.readJsonResponse(new Request());
			fail("Invalid url should have thrown an exception.");
		} catch (IOException ex) {
			// Pass
		}
	}

    public void testRreadJsonResponse_unreachableUrlThrowsAnException() {
		try {
			handler.readJsonResponse(new Request());
			fail("Unreachable url should have thrown an exception.");
		} catch (UnknownHostException ex) {
			// Pass
		} catch (IOException ex) {
			fail("Unreachable host should thrown an unreachable host exception.");
		}
	}
    
    public void testRreadJsonResponse_emptyResultString() {
    	String response = "";
    	Reader reader = new StringReader(response);
		String readResponse = handler.readJsonResponse(reader);
		assertEquals(response, readResponse);
	}
    
    public void testRreadJsonResponse_readFullString() {
    	String response =
    			"{" +
				    "\"glossary\": {" +
				        "\"title\": \"example glossary\"," +
						"\"GlossDiv\": {" +
				            "\"title\": \"S\"," +
							"\"GlossList\": {" +
				                "\"GlossEntry\": {" +
				                    "\"ID\": \"SGML\"," +
									"\"SortAs\": \"SGML\"," +
									"\"GlossTerm\": \"Standard Generalized Markup Language\"," +
									"\"Acronym\": \"SGML\"," +
									"\"Abbrev\": \"ISO 8879:1986\"," +
									"\"GlossDef\": {" +
				                        "\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\"," +
										"\"GlossSeeAlso\": [\"GML\", \"XML\"]" +
				                    "}," +
									"\"GlossSee\": \"markup\"" +
				                "}" +
				            "}" +
				        "}" +
				    "}" +
	    		"}";
    	Reader reader = new StringReader(response);
		String readResponse = handler.readJsonResponse(reader);
		assertEquals(response, readResponse);
	}
}
