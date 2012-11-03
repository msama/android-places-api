package com.ahura.places.models;

public class Geometry {
	
	private Location location;
	
	public Geometry() {
		// Default constructor needed by Gson
	}


	public Geometry(Location location) {
		super();
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
}
