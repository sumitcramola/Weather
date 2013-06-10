package com.expedia.weather.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * The Class Location.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Location {

	/** The full. */
	@XmlElement(name = "full", required = false)
	private String full;
	
	/** The city. */
	@XmlElement(name = "city", required = false)
	private String city;
	
	/** The state. */
	@XmlElement(name = "state", required = false)
	private String state;
	
	/** The state name. */
	@XmlElement(name = "state_name", required = false)
	private String stateName;
	
	/** The country. */
	@XmlElement(name = "country", required = false)
	private String country;
	
	/** The country iso. */
	@XmlElement(name = "country_iso3166", required = false)
	private String countryIso;
	
	/** The zip. */
	@XmlElement(name = "zip", required = false)
	private String zip;
	
	/** The latitude. */
	@XmlElement(name = "latitude", required = false)
	private String latitude;
	
	/** The longitude. */
	@XmlElement(name = "longitude", required = false)
	private String longitude;
	
	/** The elevation. */
	@XmlElement(name = "elevation", required = false)
	private String elevation;

	/**
	 * Gets the full.
	 *
	 * @return the full
	 */
	public String getFull() {
		return full;
	}

	/**
	 * Sets the full.
	 *
	 * @param full the new full
	 */
	public void setFull(String full) {
		this.full = full;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the state name.
	 *
	 * @return the state name
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Sets the state name.
	 *
	 * @param stateName the new state name
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the country iso.
	 *
	 * @return the country iso
	 */
	public String getCountryIso() {
		return countryIso;
	}

	/**
	 * Sets the country iso.
	 *
	 * @param countryIso the new country iso
	 */
	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the zip.
	 *
	 * @param zip the new zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the elevation.
	 *
	 * @return the elevation
	 */
	public String getElevation() {
		return elevation;
	}

	/**
	 * Sets the elevation.
	 *
	 * @param elevation the new elevation
	 */
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	
	
	

}
