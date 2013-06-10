package com.expedia.weather.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.weather.constant.RequestMappingURL;
import com.expedia.weather.constant.ViewName;
import com.expedia.weather.domain.WeatherForm;
import com.expedia.weather.model.WeatherResponse;
import com.expedia.weather.service.IWeatherService;
import com.expedia.weather.service.exception.WeatherNotAvaliableException;
import com.expedia.weather.service.impl.WeatherServiceImpl;

/**
 * Handles requests for the application home page.
 * The controller calls  {@link WeatherServiceImpl} to get the data needs send to the UI.
 */
@Controller
public class WeatherController {
	
	/** Logger to logs the request to controller  */
	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
		
	/** The weather service. */
	@Autowired
	private IWeatherService weatherService;

	
	/**
	 * This method is used to show Weather Form to the user.
	 * We are sending the newly created {@link WeatherForm} object to show empty form to the user. 
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	

	 @RequestMapping(value = RequestMappingURL.HOME_URL, method = RequestMethod.GET)
	    public ModelAndView showWeatherForm(final HttpServletRequest request, final HttpServletResponse response) {
		 
		logger.info("showWeatherForm called");
		// Create initial weather Form object
	        WeatherForm weatherForm = new WeatherForm();
	        ModelAndView modelView = new ModelAndView(ViewName.WEATHER.getViewName());
	    	modelView.addObject("weatherForm", weatherForm);
	    	return modelView;
	 }
	 
	 /**
 	 * Submit weather form takes the input from the user and calls service API to get the data.
 	 *
 	 * @param weatherForm is the Model Attribute and bind the zipcode entered in the weather form.
 	 * @param result the result binds errors.
 	 * @param session the session
 	 * @return the model and view used to pass {@link WeatherForm} and {@link weatherResponse} using model and view 
 	 */
 	@RequestMapping(value = RequestMappingURL.WEATHER_URL, method = RequestMethod.POST)
	    public ModelAndView submitWeatherForm(
	            @ModelAttribute("weatherForm") final WeatherForm weatherForm, final BindingResult result,
	            final HttpSession session) {
	       
 			logger.info("submitWeatherForm called");
 		
		 	WeatherResponse weatherResponse =null;
	        if (!result.hasErrors()) {
	        	try {
	        	
	        	  weatherResponse= weatherService.getWeatherInformation(weatherForm.getZipCode());
	        	  
	        	  if(weatherResponse != null && weatherResponse.getError() != null) {
	        		  
	        		   result.rejectValue("zipCode", "weather.zipCode.not.found", "Zipcode not found.");
	        	  }
	        	} catch (WeatherNotAvaliableException weatherExp) {
	        		
	        		result.rejectValue("zipCode", "weather.application.down", "Technical Error : please try after some time.");
	        		logger.error("Exception Occured : Technical Error : please try after some time");
	        	}
	        	
	        } 		
	        
	        ModelAndView modelView = new ModelAndView(ViewName.WEATHER.getViewName());
	    	modelView.addObject("weatherForm", weatherForm);
	    	modelView.addObject("weatherResponse", weatherResponse);
	             
	      return modelView;
	      
	    }
	 		
	 /**
 	 * Gets the weather info : This is exposed as Rest API and sends the response as JSON. 
 	 * Content Negotiation view Resolver is used to send the response as JSON.
 	 *
 	 * <P> The @ResponseBody annotation is used  to send the returned object as a resource
 	 *  to the client, converted into JSON form that the client can accept. More specifically, 
 	 *  the resource should take a form that satisfies the request’s Accept header.
 	 *  To get respons in Json you need to set the accept header to application/json.
	 * </p>
 	 * @param zipcode the zipcode
 	 * @param response the response
 	 * @return the weather info
 	 */
 	@RequestMapping(value = RequestMappingURL.WEATHER_INFO_JSON , method = RequestMethod.GET)
	@ResponseBody
	 public String getWeatherInfo (@RequestParam(value = "zipcode" ,required=false) String zipcode,HttpServletResponse response ){
			
 		logger.info("getWeatherInfo called");
 		
		String weatherResp = null;
			
			try {
				weatherResp= weatherService.getWeatherInformationJson(zipcode);
			}  catch (WeatherNotAvaliableException weatherExp) {
				logger.error("Exception Occured : Technical Error : please try after some time");
				return "Technical Error : please try after some time.";
        	}
			return weatherResp;
		}
	 	
}
