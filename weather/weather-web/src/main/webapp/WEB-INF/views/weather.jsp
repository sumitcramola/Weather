<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

<link rel="stylesheet" type="text/css" href="css/style.css" />

<script src="js/commonJQ.js" type="text/javascript"><!-- FF3 --></script> 
<script src="js/jquery-1.8.2.min.js" type="text/javascript"><!-- FF3 --></script>
<script type="text/javascript">
	$('#zipCode').keypress(function(event) {
	// if enter is pressed we need to submit form using submit form
	var keycode = (event.keyCode ? event.keyCode : event.which);
		if (keycode == '13') {
			submitForm();
			return false; // avoid to execute the actual submit of the form.
		}
	});

	window.onload = function() {
		document.getElementById("zipCode").focus();
	}
</script>
</head>
<body>
	<h1><spring:message code="weather.label.welcome.message" text="Weather Details for US ZIP CODE!"/></h1>
<body>
<h2><spring:message code="weather.label.form.submit.heading" text="Weather Details Using Submit form"/></h2>
	<div>
		<c:url value="submitWeather" var="submitWeatherURL" />
		<form:form action="${submitWeatherURL}" modelAttribute="weatherForm" id="weatherForm" method="POST">
	
<div>	
		<div>	
				
					<div class="floatL"><spring:message code="weather.label.enter.zipcode" text="Enter zip Code"/></div>
					<div class="floatL">
						<form:input path="zipCode" id="zipCode" />
					</div>

					<div id="errorZIP" class="floatL">
						<form:errors path="zipCode" cssClass="error" />
					</div>
					<div class="clear"></div>
					<div class="spacer"></div>
			
				<div >
						<input type="button" value="submit" onclick="submitForm();">
				</div>
		</div>
		<div class="clear"></div>
		<div >
				
				<c:if test="${not empty weatherResponse.observation}">
						<div id="weatherInfo">
							<div >
								<div class="width30"><spring:message code="weather.label.city" text="CITY"/></div>
								<div class="width30"><spring:message code="weather.label.state" text="STATE"/></div>
								<div class="width30"><spring:message code="weather.label.temprature" text="TEMPRATURE"/></div>
							</div>
							<div class="clear"></div>
							<div >
								<div class="width30">${weatherResponse.observation.observationLocation.city}</div>
								<div class="width30">${weatherResponse.observation.observationLocation.state}</div>
								<div class="width30">${weatherResponse.observation.tempratureString}</div>
							</div> 
						</div>
					</c:if>
				
					
			</div> 
</div>
				
		</form:form>

	</div>
	
	
	
	<div class="spacer"></div>
	<div> ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</div>
	<div class="spacer"></div>
	<h2><spring:message code="weather.label.ajax.submit.heading" text="Weather Details Using Ajax"/></h2>
	<div >
		<form:form modelAttribute="weatherForm" id="weatherFormAjax" method="POST" onsubmit="return false;">
		
		<div >	
				
					<div class="floatL">Enter Zip Code</div>
					<div class="floatL">
						<form:input path="zipCode" id="zipCodeAjax" />
					</div>
					
					<div id="errorAzaxZIP" class="floatL">

					</div>
					
					<div class="clear"></div>
					<div class="spacer"></div>
			
				<div >
						<input type="button" value="submit by ajax" onclick="callAjaxRequest();">
				</div>
				
				<div id="weatherDivAjax">
				</div>
		</div>
		
	<%-- 		<div>
				<div>
					<div>Enter Zip Code</div>
					<div>
						<form:input path="zipCode" id="zipCodeAjax" />
					</div>
					<div>
					</div>
					<div>
						<input type="button" value="submit by ajax" onclick="callAjaxRequest();">
					</div>
				</div>

				<div id="weatherDivAjax">
				</div>
			
			</div> --%>
				
		</form:form>

	</div>
	
	
		

</body>


</body>
</html>
