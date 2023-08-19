package api.endpoints;

//here this is another approach of calling the url from routes.properties file 

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

public class UserEndpoints2 {

	
	public static ResourceBundle getURL()
	{
		ResourceBundle routes_url=ResourceBundle.getBundle("routes"); //routes is name of properties file
				
				return routes_url;
	}

	public static Response createUser(User payload)
	{
		
		String post_url=getURL().getString("post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
       
		
        return response;
	}
	
	
	public static Response getUser(String user_Name)
	{
		String get_url=getURL().getString("get_url");
		
		//this user_Name we will get from POJO classes getters method
		Response response=given()
		.pathParam("username", user_Name)
		
		
		.when()
		.get(get_url);
		return response;
		
	}
	
	public static Response updateUser(String user_Name, User payload)
	{
		String update_url=getURL().getString("update_Url");
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", user_Name)
		.body(payload)
		
		.when()
		.put(update_url);
		
		return response; 
		
		
	}
	
	public static Response deleteUser(String user_Name)
	{
		
		String delete_Url=getURL().getString("delete_url");
		Response response =given()
		.pathParam("username", user_Name)
		
		.when()
		.delete(delete_Url);
		
		return response;
	}
	
	
	
	
	
}
