package com.ahura.places.models;

public class SearchResult {
	
	private String[] html_attributions;
	private Place []  results;
	private String status;

	public SearchResult() {
		// Default constructor needed by Gson
	}

	public String[] getHtml_attributions() {
		return html_attributions;
	}

	public void setHtml_attributions(String[] html_attributions) {
		this.html_attributions = html_attributions;
	}

	public Place[] getResults() {
		return results;
	}

	public void setResults(Place[] results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
