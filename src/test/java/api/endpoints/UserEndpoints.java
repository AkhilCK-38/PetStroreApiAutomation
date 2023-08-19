package api.endpoints;

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UserEndpoints {


	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.postUser_url);
       
		
        return response;
	}
	
	
	public static Response getUser(String user_Name)
	{
		//this user_Name we will get from POJO classes getters method
		Response response=given()
		.pathParam("username", user_Name)
		
		
		.when()
		.get(Routes.getUser_url);
		return response;
		
	}
	
	public static Response updateUser(String user_Name, User payload)
	{
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", user_Name)
		.body(payload)
		
		.when()
		.put(Routes.updateUser_url);
		
		return response; 
		
		
	}
	
	public static Response deleteUser(String user_Name)
	{
		Response response =given()
		.pathParam("username", user_Name)
		
		.when()
		.delete(Routes.deleteUser_url);
		
		return response;
	}
	
	
	
	
	
}
