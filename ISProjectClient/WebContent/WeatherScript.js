$(document).ready(function(){
	$.ajax({
		method: "GET",
		url: "http://api.ipstack.com/check?access_key=2aea71368c3c6ef4dc811f1c54af7d11",
		error: ajaxReturn_Error,
		success: ajaxReturn_Success
	})
	
	function ajaxReturn_Success(result, status, xhr) {
		ParseJsonFile(result);
	}
	
	function ajaxReturn_Error(result, status, xhr) {
		$("#errorResponse").html("Error fetch weather service");
	} 
});// End ready function

function ParseJsonFile(result) {
	var lat = result.latitude;
	var long = result.longitude;
	var city = result.city;
	var ipNbr = result.ip
	$("#city").text("City: "+city);
	$("#ipNbr").text("IP Number: "+ipNbr);
	$.ajax({
		method: "GET",
		url:
			"http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+long+"&units=metric"+ "&APPID=2544783e23a1f9904cd9a164b591c227",
		error: ajaxWeatherReturn_Error,
		success: ajaxWeatherReturn_Success
	})
	function ajaxWeatherReturn_Success(result, status, xhr) {
		var sunrise = result.sys.sunrise;
		var sunset = result.sys.sunset;
		var sunriseDate = new Date(sunrise*1000);
		var timeStrSunrise = sunriseDate.toLocaleTimeString();
		var sunsetDate = new Date(sunset*1000);
		var timeStrSunset = sunsetDate.toLocaleTimeString();
		$("#sunrise").text("Sunrise: "+timeStrSunrise);
		$("#sunset").text("Sunset: "+timeStrSunset);
		$("#weather").text("Weather: "+result.weather[0].main);
		$("#degree").text("Degrees: "+result.main.temp+" \u2103");
	}
	function ajaxWeatherReturn_Error(result, status, xhr) {
		$("#errorResponse").html("Error fetch weater service");
	}
 }