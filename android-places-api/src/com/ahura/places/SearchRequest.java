package com.ahura.places;

import android.location.Location;

/**
 * @author pani
 * @see https://developers.google.com/places/documentation/search
 */
public class SearchRequest extends Request {

	public static final String LOCATION = "location";
	public static final String RADIUS = "radius";
	public static final String SENSOR = "sensor";


	public static SearchRequest create(
			Location location, int radius, boolean sensor) {
		return new SearchRequest()
			.putLocation(location)
			.putRadius(radius)
			.putSensor(sensor);
	}
	
	public SearchRequest() {
		super();
	}
	
	public SearchRequest putSensor(boolean sensor) {
		return (SearchRequest) put(SENSOR, "" + sensor);
	}


	public SearchRequest putRadius(int radius) {
		return (SearchRequest) put(RADIUS, "" + radius);
	}


	public SearchRequest putLocation(Location location) {
		return (SearchRequest) put(LOCATION, location.getLatitude() + "," + location.getLongitude());
	}


}
