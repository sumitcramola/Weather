/**
 *This API submits the form with the ajax request
 */

function callAjaxRequest() {
		submitFormByAjaxRequest("weatherFormAjax", "weatherDivAjax",
				"errorAzaxZIP");
	}

	function submitForm() {
		$("div#weatherInfo").html("");
		$("div#rrorZIP").html("");
		var zipCode = $('#zipCode').val();
		if (zipCode.length != 5) {
			$("div#errorZIP").html(
					"<div class='error'>Invalid zip code format.</div>");
			return false;
		}
		$('form#weatherForm').submit();
	}
	
function submitFormByAjaxRequest(formId,responseDiv,errorDiv) {
	$("div#" + responseDiv).html("");
	$("div#" + errorDiv).html("");
	
	var zipCode = $('#zipCodeAjax').val();
	if(zipCode.length != 5)
	{
		$("div#" + errorDiv).html("<div class='error'>Invalid zip code format.</div>");
		return false;
	}
	
	$("div#" + responseDiv).html("fetching .....");
	$.ajax({
		type : "GET",
		beforeSend: function (request)
        {
            request.setRequestHeader('Accept', 'application/json');
        },
		error : function(jqXHR, textStatus, errorThrown) {
			$("div#" + responseDiv).html("");
			$("div#" + errorDiv).html("<div class='error'>"+jqXHR.responseText+"</div>");
		},
		url : "getWeatherInfo?zipcode="+zipCode,
		data : $("#" + formId).serialize(), // serializes the form's elements.
		success : function(data) {
			if (data.response.error != null) {
				$("div#" + responseDiv).html("");
				$("div#" + errorDiv).html("<div class='error'>zipcode not found</div>");
			} else {
				
				var location = data.current_observation.observation_location ;
				var temperature = data.current_observation.temperature_string ;
				var createDivData="";
				createDivData ="<div> <div class='width30'>CITY</div> " +
									 "<div class='width30'>STATE</div>" +
									 "<div class='width30'>TEMPRATURE</div>" +
									 "</div> <div class='clear'></div>" +
												"<div>	<div class='width30'>" + location.city +	
												"</div> <div class='width30'>" + location.state + 
												"</div> <div class='width30'>" + temperature + 
												"</div></div>";
				
				$("div#" + responseDiv).html(createDivData);
			}
		},
		dataType : "json"
	});

	return false; // avoid to execute the actual submit of the form.
}