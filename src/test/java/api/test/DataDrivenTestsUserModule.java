package api.test;
import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DataDrivenTestsUserModule {

	@Test(priority=1,dataProvider="allData",dataProviderClass=DataProviders.class)
	public void testPostUser(String userid,String uname,String fname,String lname,String email, String pwd,String ph)
	{
		User userPayloadData=new User();
		
		userPayloadData.setId(Integer.parseInt(userid));
		userPayloadData.setUsername(uname);
		userPayloadData.setFirstName(fname);
		userPayloadData.setLastName(lname);
		userPayloadData.setEmail(email);
		userPayloadData.setPassword(pwd);
		userPayloadData.setPhone(ph);
		
		
		Response response=UserEndpoints.createUser(userPayloadData);
		
		//validations
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	//deleting all the users
	
	@Test(priority=2,dataProvider="userNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		
		Response response=UserEndpoints.deleteUser(userName);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
