package com.expedia.weather.service;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.expedia.weather.model.WeatherResponse;
import com.expedia.weather.service.exception.WeatherNotAvaliableException;

/**
 * The Class WeatherTestService.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext-service.xml" })
public class AppTest {
	

	/** Logger. */
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
	
	/** The weather service. */
	@Autowired
	IWeatherService weatherService;
	
	/**
	 * Test valid zip code.
	 */
	@Test
    public void testValidZipCode() {
		
		logger.info("Testing for Valid Zip Code for 94116");
		
		try {
		WeatherResponse weatherResponse= weatherService.getWeatherInformation("94116");
		
		assertNotNull("weather Response not null " ,weatherResponse);
		assertNotNull("weather Observation not null " ,weatherResponse.getObservation());
		assertNotNull("weather Observation Locaction not null " ,weatherResponse.getObservation().getObservationLocation());
		
		logger.info("Resposne recieved sucessfully for 94116"); 
		
		logger.info("City : {}  " ,weatherResponse.getObservation().getObservationLocation().getCity());
		logger.info("state : {}  " ,weatherResponse.getObservation().getObservationLocation().getCity());
		logger.info("Temprature : {}  " ,weatherResponse.getObservation().getTempratureString());

		} catch (WeatherNotAvaliableException weatherException) {
			logger.error("Exception Occured :", weatherException.getMessage());
		} catch (Exception e) {
			logger.error("Exception Occured :", e.getMessage());
		}
		
	
    }

   @Test
    /**
   * Tes zip code not found.
   */
  public void testZipCodeNotFound() {
    	
    	logger.info("Testing for Zip Code not found for zipcode : 11111");
		
    	try {
		WeatherResponse weatherResponse= weatherService.getWeatherInformation("11111");	
		
		assertNotNull("weather Response not null " ,weatherResponse);
		if(weatherResponse.getError() != null) {
			logger.info("Error Type : {}  " ,weatherResponse.getError().getType());
			logger.info("Error Description : {}  " ,weatherResponse.getError().getDescription());
		}
			
    	} catch (WeatherNotAvaliableException e) {
    		logger.error("Exception Occured : Calling Rest Srevice" ,e );
		}
    	catch (Exception e) {
    		logger.error("Exception Occured : " ,e );
		}
		
    }
}
