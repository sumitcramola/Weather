package com.expedia.weather.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.expedia.weather.model.type.FeatureType;

/**
 * The Class WeatherResponse.
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherResponse {
	

	/** The version. */
	@XmlElement(name = "version", required = false)
	private String version;

	/** The terms of service. */
	@XmlElement(name = "termsofService", required = false)
	private String	 termsOfService;
	
	
	/** The features. */
	@XmlElementWrapper(name = "features")
	@XmlElement(name = "feature", required=false)
	private List<FeatureType> features;
	
	/** The observation. */
	@XmlElement(name = "current_observation", required=false)
	private Observation observation;
	
	/** The error. */
	@XmlElement(name = "error", required=false)
	private Error error;
	
	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Gets the terms of service.
	 *
	 * @return the terms of service
	 */
	public String getTermsOfService() {
		return termsOfService;
	}


	/**
	 * Sets the terms of service.
	 *
	 * @param termsOfService the new terms of service
	 */
	public void setTermsOfService(String termsOfService) {
		this.termsOfService = termsOfService;
	}


	/**
	 * Gets the features.
	 *
	 * @return the features
	 */
	public List<FeatureType> getFeatures() {
		return features;
	}


	/**
	 * Sets the features.
	 *
	 * @param features the new features
	 */
	public void setFeatures(List<FeatureType> features) {
		this.features = features;
	}


	/**
	 * Gets the observation.
	 *
	 * @return the observation
	 */
	public Observation getObservation() {
		return observation;
	}


	/**
	 * Sets the observation.
	 *
	 * @param observation the new observation
	 */
	public void setObservation(Observation observation) {
		this.observation = observation;
	}

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public Error getError() {
		return error;
	}

	/**
	 * Sets the error.
	 *
	 * @param error the new error
	 */
	public void setError(Error error) {
		this.error = error;
	}
	
	

}
