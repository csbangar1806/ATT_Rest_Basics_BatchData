package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	
	public static RequestSpecification reqSpec()
	{
		return new RequestSpecBuilder()
		
		.setBaseUri("https://api.spotify.com")	
		
		.setBasePath("/v1")
		
		//.addHeader("Authorization", "Bearer BQAde80LAb1m3kzi95l_6lzJp40Q0LrI-yuPwVGbhSvgUeP62R7zqsZeBi0YyN9daUHyLKkFkdxy9gvzt-MG9J7g0CsJiYGtu2ESEkXjfEDQVaQyUfvj-eq8Kmz62axOV9VuWOYDHhWA22kI8iedWthb2ri5JFBjNMK9BelyHYtYTGz-yOToms7cKpGj7GIEBcaQjZG94XjTPI6d3jSIh9CQqANQTII40nkdVoIS0sTK643HoYi-P1hfMiUaMpo-7E-cDdw32FjNIzxW")
		
		.setContentType(ContentType.JSON)
		
		.log(LogDetail.ALL)
		
		.build();
	
	}
	
	public static ResponseSpecification resSpec()
	{
		return new ResponseSpecBuilder()
		
		.expectContentType(ContentType.JSON)
		
		.log(LogDetail.ALL)

		.build();
	}

}
