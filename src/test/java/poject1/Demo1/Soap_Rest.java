package poject1.Demo1;

import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class Soap_Rest 
{
@Test(enabled=false)
public void Rest()
{
RestAssured.baseURI="https://reqres.in";	
RestAssured.given().contentType("application/json").
body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"leader\"\r\n}").

when().post("/api/users").

then().statusCode(201);
}
	
@Test()	
public void Soap()
{
	RestAssured.baseURI="http://www.webservicex.com/globalweather.asmx";
	RestAssured.given().contentType("text/xml").body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.webserviceX.NET\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <web:GetCitiesByCountry>\r\n         <!--Optional:-->\r\n         <web:CountryName>india</web:CountryName>\r\n      </web:GetCitiesByCountry>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>").
	
	when().post("").
	then().statusCode(200);
}
	
	
}
