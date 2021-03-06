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
		handler = new JSonResponseHandler(key, baseUrl);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConstructor_addTrailingSlashOnlyIfNeeded() {
		handler = new JSonResponseHandler(key, baseUrl + "/");
		
		assertEquals(baseUrl + "/json?key=" + key,
				handler.composeUrl(new Request()));
	}
	
	public void testComposeUrl_empty() {
		assertEquals(baseUrl + "/json?key=" + key,
				handler.composeUrl(new Request()));
	}
	
	public void testComposeUrl_base64() {
		Request params = new Request()
		.put("foo$", "foo%")
		// space " " is encoded as "+"
		.put("bar K", "bar&");

		assertEquals(
				baseUrl + "/json?key=" + key + "&foo%24=foo%25&bar+K=bar%26",
				handler.composeUrl(params));
	}
	
	public void testComposeUrl_withParam() {
		Request params = new Request()
				.put("barK", "barV")
				.put("fooK", "fooV");
		
		assertEquals(
				baseUrl + "/json?key=" + key + "&fooK=fooV&barK=barV",
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
    
    public void testRreadJsonResponse_emptyResultString() throws IOException {
    	String response = "";
    	Reader reader = new StringReader(response);
		String readResponse = handler.readJsonResponse(reader);
		assertEquals(response, readResponse);
	}
    
    public void testReadJsonResponse_readFullString() throws IOException {
    	String response =
    			"{\n" +
				    "\"glossary\": {\n" +
				        "\"title\": \"example glossary\",\n" +
						"\"GlossDiv\": {\n" +
				            "\"title\": \"S\",\n" +
							"\"GlossList\": {\n" +
				                "\"GlossEntry\": {\n" +
				                    "\"ID\": \"SGML\",\n" +
									"\"SortAs\": \"SGML\",\n" +
									"\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
									"\"Acronym\": \"SGML\",\n" +
									"\"Abbrev\": \"ISO 8879:1986\",\n" +
									"\"GlossDef\": {\n" +
				                        "\"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
										"\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
				                    "},\n" +
									"\"GlossSee\": \"markup\"\n" +
				                "}\n" +
				            "}\n" +
				        "}\n" +
				    "}\n" +
	    		"}";
    	Reader reader = new StringReader(response);
		String readResponse = handler.readJsonResponse(reader);
		assertEquals(response, readResponse);
	}
}
