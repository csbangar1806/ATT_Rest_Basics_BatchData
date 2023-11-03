package authmanager;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TokenGenerator {
	
	
	public static String renewToken()
	{
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", "AQBHmPTt5Cz5TX47cwPC7jdn0zex_Ayyhty3qWcY33G_PG8PeAJS2ouCbcjVUUEOpdq3Wu6nxRManAyJDs6D4dJk2Y30H0GcNs6MgmPd1fM72yM93YgTWJAxf7AJvMiUbN0");
		param.put("client_id", "309adab0e56d4d52bf19ad64bbcb4fe2");
		param.put("client_secret", "71282b34e6814555a49a3a4ea6c4693e");
		RestAssured.baseURI = "https://accounts.spotify.com";
		
		Response response = given()
		
		.contentType(ContentType.URLENC)
		
		.formParams(param)
		
		.when()
		
		.post("api/token")
		
		.then()
		
		.extract()
		
		.response();
		
		String accessToken = response.path("access_token");
		
		if(response.statusCode()!= 200)
		{
			throw new RuntimeException("Failed to generate the access token");
		}
		
		return accessToken;
		
	}
	

}
