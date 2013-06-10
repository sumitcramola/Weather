package com.expedia.weather.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The Class Observation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "current_observation")
public class Observation {

	/** The image. */
	@XmlElement(name = "image", required=false)
	private Image image;
	
	/** The observation location. */
	@XmlElement(name = "observation_location", required=false)
	private Location observationLocation;
	
	
	/** The temprature string. */
	@XmlElement(name = "temperature_string", required = false)
    private String tempratureString;

	
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Gets the observation location.
	 *
	 * @return the observation location
	 */
	public Location getObservationLocation() {
		return observationLocation;
	}

	/**
	 * Sets the observation location.
	 *
	 * @param observationLocation the new observation location
	 */
	public void setObservationLocation(Location observationLocation) {
		this.observationLocation = observationLocation;
	}

	/**
	 * Gets the temprature string.
	 *
	 * @return the temprature string
	 */
	public String getTempratureString() {
		return tempratureString;
	}

	/**
	 * Sets the temprature string.
	 *
	 * @param tempratureString the new temprature string
	 */
	public void setTempratureString(String tempratureString) {
		this.tempratureString = tempratureString;
	}
   
	
}
