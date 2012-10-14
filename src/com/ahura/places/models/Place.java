/**
 * 
 */
package com.ahura.places.models;


/**
 * Encapsulates the information fetched from the json Google
 * places API.
 * 
 * <p>This is a model class for the MVC pattern. 
 * 
 * <p>With a keyword based search in the search API basic
 * information are gathered. More details can be obtained
 * by a second call to the details API.
 * 
 * @author pani
 * @see https://developers.google.com/places/documentation/search
 * @see https://developers.google.com/places/documentation/details
 * 
 * 
 */
public class Place {
	
	private String formatted_address;
	private Geometry geometry;
	private String icon;
	private String id;
	private String name;
	private double rating;
	private String reference;
	private String[] types;
	
	public Place() {
		// Default constructor needed by Gson
	}

	public Place(String icon, String id, String name) {
		super();
		this.icon = icon;
		this.id = id;
		this.name = name;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}
	
}
