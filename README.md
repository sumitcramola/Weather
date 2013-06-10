
 Create a spring 3 java web application that displays the weather.

Weather Ground API kye : ed044d75b91fb500
-----------------------------------------------------------------------------------
Build and Run

Using Command prompt :
1) Install maven Version 3.
2) Download the zip from gitup and unzip it.
3) go to Unzip folder.
4) Build project using Mvn Command : mvn clean install
5) Run application on tomcat      : mvn tomcat:run
6) In browser type : http://localhost:8080/weather-web/

-----------------------------------------------------------------------------------
I have done it using both the approaches XML and JSON.

There are two sections of Screen .
1) First Section : Submit the form using simple spring Flow. 
   This will call Weather Ground Rest API that return response in XML.
	
2) Section Section : Get the Data Using Ajax.
   This will call Weather Ground Rest API that return response in JSON.

Configuration : application-config.properties contains keys and URlS 
weather.condtion.url.key =ed044d75b91fb500
weather.condtion.url = http://api.wunderground.com/api/{key}/conditions/q/{zipcode}.xml
weather.condtion.url.json = http://api.wunderground.com/api/{key}/conditions/q/{zipcode}.json

Validations :
1. AppTest contains two methods for testValidZipCode() and testZipCodeNotFound()

Server Side validations using Junit:
1) Valid Zip Code :
When the user enters a valid us zipcode into the form and clicks the button, it should display
 a page with the city name, state name, and current temperature in fahrenheit.

2) Zipcode not found : for zipcode : 11111.
If the user enters an input that is in the correct format but the zip code does not exist the page
 should display an error: 'zipcode not found'

Client side validation: To avoid extra call to server.
1) Invalid Zip code Format :
If the user puts in an input that is not in the correct format for a zip code (5 numbers) the page
 should display an error: "Invalid zip code format'.
