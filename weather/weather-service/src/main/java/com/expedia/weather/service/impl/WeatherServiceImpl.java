package com.expedia.weather.service.impl;

import java.util.HashMap;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.expedia.weather.model.WeatherResponse;
import com.expedia.weather.service.IWeatherService;
import com.expedia.weather.service.exception.WeatherNotAvaliableException;

// TODO: Auto-generated Javadoc
/**
  * The Class WeatherServiceImpl is implementation of <tt>IWeatherService</tt> interface.
  * <p> The service will call the Weather Underground API using {@link RestTemplate}. </p>
  * <tt>getWeatherInformation</tt> will call Weather Underground Rest API exposed as XML and return  response  as {@link WeatherResponse}.
  * <tt>getWeatherInformationJson</tt>  will call Weather Underground Rest API exposed as JSON and return response  as {@link String}.
  * </p>
  * 
  */
 @Service
public class WeatherServiceImpl implements IWeatherService {
	
	/** Logger. */
	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	
	/** The rest template.*/
	@Autowired
	protected RestTemplate restTemplate;
	
	/* properties are configured in application-config.properties file.
	 */
	/** The current weather url : maps to xml url. */
	@Value("${weather.condtion.url}")
	private String currentWeatherURL;
	
	/** The current weather json url : maps to json url . */
	@Value("${weather.condtion.url.json}")
	private String currentWeatherJsonURL;
	
	/** The key : maps to Weather Underground API. */
	@Value("${weather.condtion.url.key}")
	private String key;
	
	
	/*
	 *  @param zipcode the zipcode
	 * (non-Javadoc)
	 * @see com.expedia.weather.service.IWeatherService#getWeatherInformation(java.lang.String)
	 *
	 */
	public WeatherResponse getWeatherInformation(String zipcode)  {
		
		logger.info("getWeatherInformation called");
	
		Map<String, String> params = new HashMap<String, String>();
		params.put("key",key);
		params.put("zipcode",zipcode);
		
		WeatherResponse response = null;
		try{
		response = restTemplate.getForObject(currentWeatherURL, WeatherResponse.class, params);
		logger.debug("response received sucessfully");
		} catch (RestClientException restClientExp) {
			logger.error("Exception Occured : Calling Rest Srevice using key : {} for zipcode : {} : Error : {}", key, zipcode);
			throw new WeatherNotAvaliableException("Exception Occured : Calling Rest Srevice.",restClientExp);
		} 
		catch (Exception e) {
			logger.error("Exception Occured : Calling Rest Srevice using key : {} for zipcode : {} : Error : {}", key, zipcode);
			throw new WeatherNotAvaliableException("Exception Occured : Calling Rest Srevice.", e);
		}
		return response;
		
	}
	
	/* (non-Javadoc)
	 * @see com.expedia.weather.service.IWeatherService#getWeatherInformationJson(java.lang.String)
	 */
	public String getWeatherInformationJson(String zipcode) {

		logger.info("getWeatherInformationJson called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("key", key);
		params.put("zipcode", zipcode);

		String response;
		try {
			response = restTemplate.getForObject(currentWeatherJsonURL,String.class, params);
			logger.debug("response received sucessfully");
		} catch (RestClientException restClientExp) {
			logger.error("Exception Occured : Calling Rest Srevice using key : {} for zipcode : {} ", key, zipcode);
			throw new WeatherNotAvaliableException("Exception Occured : Calling Rest Srevice.", restClientExp);
		}
		return response;

	}	
	

}
