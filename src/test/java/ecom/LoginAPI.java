package ecom;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginAPI {
static	String tokenValue;
static String userId;
	
	@Test(priority = 1)
	public void loginToApp()
	{
		
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		Response response = given()
		
		.header("Content-Type", "application/json")
		
//		.body("{\r\n"
//				+ "    \"userEmail\": \"testuser1234@gmail.com\",\r\n"
//				+ "     \"userPassword\": \"Test@1234\"\r\n"
//				+ "}")
		
		.body("{\n"
				+ "  \"userEmail\": \"test.user123@gmail.com\",\n"
				+ "  \"userPassword\": \"Shree1234@\"\n"
				+ "}")
		
		.log().all()
		
		.when()
		
		.post("/api/ecom/auth/login")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
		 tokenValue = jp.getString("token");
		
		 userId = jp.getString("userId");
		
	}
	
	@Test(priority = 2)
	public void addProduct()
	{
		
	//	String path = System.getProperty("user.dir")+"\\src\\test\\resources\\Test Product image2.png";
		
	//	File image = new File(path);
		
		File image = new File("C:\\Users\\C S Bangar\\eclipse-workspace\\ATT_API_PracticeProj\\src\\test\\resources\\test img 3.jpeg");

		
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		given()
		
		.header("Authorization", tokenValue)
		
		.param("productName", "casual shirt")
		
		.param("productAddedBy", userId)
		
		.param("productCategory", "fashion")
		
		.param("productSubCategory", "shirt")
		
		.param("productPrice", "1500")
		
		.param("productDescription", "Party wear shirt")
		
		.param("productFor", "Women")
		
		.multiPart("productImage", image )
		
		.when()
		
		.post("api/ecom/product/add-product")
		
		.then()
		
		.log()
		
		.all();
		
	}
	

}
