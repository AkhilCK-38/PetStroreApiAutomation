package api.test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests {
     User userPayloadData;
	 Faker faker;
	Logger logger;
	 
	 @BeforeClass
	public void setup()
	{
		userPayloadData= new User();
		faker= new Faker();
		
		//assigning data to setter methods of User Pojo class user faker library
		
		userPayloadData.setId(faker.idNumber().hashCode());
		userPayloadData.setUsername(faker.name().username());
		userPayloadData.setFirstName(faker.name().firstName());
		userPayloadData.setLastName(faker.name().lastName());
		userPayloadData.setEmail(faker.internet().safeEmailAddress());
		userPayloadData.setPassword(faker.internet().password(5, 10));
		userPayloadData.setPhone(faker.phoneNumber().cellPhone());
		logger=LogManager.getLogger(this.getClass());
		
	}
	 
	 @Test(priority=1)
	 public void testPostUser()
	 {
		  logger.info("*************testPostUser Metod created************************");
		  logger.info("*************Creating user************************");
		Response response= UserEndpoints.createUser(userPayloadData);
			
		
		response.then().log().all();
		
		//Validation can be done here now
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************user created************************");
		 
	 }
	 
	 
	 
	 @Test(priority=2)
	 public void testGetUser()
	 {
		 
		  logger.info("*************testGetUser Metod created************************");
		  logger.info("*************Reading user info************************");
		 Response response=UserEndpoints.getUser(this.userPayloadData.getUsername());
		 
		 //validations
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 logger.info("*************user is displayed************************");
		 
	 }
	 
	 @Test(priority=3)
	 public void testUpdateUser()
	 {
		 
		  logger.info("*************testUpdateUser Metod created************************");
		  logger.info("*************updating user************************");
		 //spicify which all fields u want to update
		    userPayloadData.setFirstName(faker.name().firstName());
			userPayloadData.setLastName(faker.name().lastName());
			userPayloadData.setEmail(faker.internet().safeEmailAddress());
		 
		 Response response=UserEndpoints.updateUser(this.userPayloadData.getUsername(), userPayloadData);
		 
		 response.then().log().all();
		 
		 //status code validation using testng libray
		 //Assert.assertEquals(response.getStatusCode(), 200);
		 //OR status code validations with Rest assured library
		 response.then().log().body().statusCode(200);
		 
		 //again verify whether the details are updated or not
		 Response responseAfterUpdation=UserEndpoints.getUser(this.userPayloadData.getUsername());
		 Assert.assertEquals(responseAfterUpdation.getStatusCode(), 200);
		 logger.info("*************user updated************************");
	 }
	 
	 @Test(priority=4)
	 public void testdeleteUser()
	 {
		 logger.info("*************testdeleteUser Metod created************************");
		  logger.info("*************Deleting user************************");
		Response response= UserEndpoints.deleteUser(this.userPayloadData.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************user Deleted************************");
	 }
	
}
