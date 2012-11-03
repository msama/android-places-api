package com.ahura.places;

import com.ahura.places.models.SearchResult;

public interface SearchResultsListener {
	
	void onSearchResultFetched(SearchResult searchResult);

}
