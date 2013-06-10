package com.expedia.weather.domain;

/**
 * The Class WeatherForm.
 */
public class WeatherForm {
	
	/** The zip code. */
	private String zipCode;

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	  /** The variable show if the form has errors or not. */
    private Boolean hasErrors;

	/**
	 * Gets the checks for errors.
	 *
	 * @return the checks for errors
	 */
	public Boolean getHasErrors() {
		return hasErrors;
	}

	/**
	 * Sets the checks for errors.
	 *
	 * @param hasErrors the new checks for errors
	 */
	public void setHasErrors(Boolean hasErrors) {
		this.hasErrors = hasErrors;
	}
	

}
