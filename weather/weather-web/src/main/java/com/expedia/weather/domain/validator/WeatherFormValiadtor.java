package com.expedia.weather.domain.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.expedia.weather.domain.WeatherForm;

/**
 * The Class WeatherFormValiadtor.
 */
@Component
public class WeatherFormValiadtor implements Validator  {
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		 return WeatherForm.class.isAssignableFrom(clazz);
	}
	
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		
		WeatherForm weatherForm = (WeatherForm) target;
		if(weatherForm.getZipCode() != null && !(weatherForm.getZipCode().length() == 5 )){
			errors.rejectValue("zipCode", "weather.zipCode.invalid.length", "invalid zip code format");
		}		

	}
	

}
