package com.expedia.weather.service;

import com.expedia.weather.model.WeatherResponse;
import com.expedia.weather.service.exception.WeatherNotAvaliableException;

/**
 * The Interface IWeatherService defines the business method to call the Weather Underground API.
 * 
 **/
public interface IWeatherService {

	/**
	 * 
	 * Gets the weather information will call Weather Underground Rest API exposed as XML and return  response  as {@link WeatherResponse}.
	 * 
	 * @param zipcode
	 *            the zipcode
	 * @return the weather information
	 */
	WeatherResponse getWeatherInformation(String zipcode) throws WeatherNotAvaliableException;

	/**
	 * Gets the weather information json will call Weather Underground Rest API exposed as JSON and return response  as {@link String}.
	 * 
	 * @param zipcode
	 *            the zipcode
	 * @return the weather information json
	 */
	String getWeatherInformationJson(String zipcode) throws WeatherNotAvaliableException;

}
