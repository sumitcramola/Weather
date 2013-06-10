package expedia.weather.model.test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.expedia.weather.model.Error;
import com.expedia.weather.model.Image;
import com.expedia.weather.model.Location;
import com.expedia.weather.model.Observation;
import com.expedia.weather.model.WeatherResponse;
import com.expedia.weather.model.type.FeatureType;

public class GenerateXml {

	public static void main(String... args) throws JAXBException {

		StringWriter writer = new StringWriter();
		printWeatherResponse(writer);
		printErrorWeatherResponse(writer);
	}
	
		private static void printErrorWeatherResponse(StringWriter writer)
				throws JAXBException {
			
			JAXBContext context = JAXBContext
					.newInstance("com.expedia.weather.model");
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(
					true));
			
			WeatherResponse weatherResp = new WeatherResponse();
			weatherResp.setVersion("0.1");
			weatherResp.setTermsOfService("http://www.wunderground.com/weather/api/d/terms.html");
			weatherResp.setFeatures(getFeatures());
			weatherResp.setError(getError());
					
			marshaller.marshal(weatherResp, writer);

			System.out.println(writer);
			
		}
		

	private static Error getError() {
			Error error = new Error();
			error.setType("querynotfound");
			error.setDescription("No cities match your search query");
			return error;
		}

	private static void printWeatherResponse(StringWriter writer)
			throws JAXBException {
		// TODO Auto-generated method stub

		JAXBContext context = JAXBContext
				.newInstance("com.expedia.weather.model");
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(
				true));
		WeatherResponse request = getWeatherResponse();
		marshaller.marshal(request, writer);

		System.out.println(writer);
		
	}

	private static WeatherResponse getWeatherResponse() {
		WeatherResponse weatherResp = new WeatherResponse();
		weatherResp.setVersion("0.1");
		weatherResp.setTermsOfService("http://www.wunderground.com/weather/api/d/terms.html");
		weatherResp.setFeatures(getFeatures());
		weatherResp.setObservation(getObservation());
		return weatherResp;
	}

	private static Location getObservationLocation() {
		Location location = new Location();
		location.setFull("San Francisco, CA");
		location.setCity("San Francisco");
		location.setState("CA");
		location.setStateName("California");
		location.setCountry("California");
		location.setCountryIso("US");
		location.setZip("94116");
		location.setLatitude("37.74430466");
		location.setLongitude("-122.48248291");
		location.setElevation("100.00000000");	
		return location;
	}

	private static Observation getObservation() {
		Observation observation = new Observation();
		observation.setTempratureString("54.1 F (12.3 C)");
		observation.setImage(getImage());
		observation.setObservationLocation(getObservationLocation());
		return observation;
	}

	private static Image getImage() {
		Image image = new Image();
		image.setUrl("http://icons-ak.wxug.com/graphics/wu2/logo_130x80.png");
		image.setTitle("Weather Underground");
		image.setLink("http://www.wunderground.com");
		return image;
	}

	private static List<FeatureType> getFeatures() {
		List<FeatureType> features= new ArrayList<FeatureType>();
		features.add(FeatureType.CONDITIONS);
		return features;
	}
	

}
