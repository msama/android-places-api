package com.ahura.places;

import android.location.Location;

public class SearchRequest extends Request {

	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String RADIUS = "radius";
	public static final String SENSOR = "sensor";


	public static SearchRequest create(
			Location location, int radius, boolean sensor) {
		return new SearchRequest()
			.putLatitude(location.getLatitude())
			.putLongitude(location.getLongitude())
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


	public SearchRequest putLongitude(double longitude) {
		return (SearchRequest) put(LONGITUDE, "" + longitude);
	}


	public SearchRequest putLatitude(double latitude) {
		return (SearchRequest) put(LATITUDE, "" + latitude);
	}

}
