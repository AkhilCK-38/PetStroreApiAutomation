package api.endpoints;

/*
 * Swagger URI : https://petstore.swagger.io/
 * 
 * Create User(post) : https://petstore.swagger.io/v2/user
 * Get User(Get) : https://petstore.swagger.io/v2/user/{username}
 * Update User(put) : https://petstore.swagger.io/v2/user/{username}
 * delete User(delete) : https://petstore.swagger.io/v2/user/{username}
 * 
 * 
 */



public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	
	//User Module
	
	public static String postUser_url=base_url+"/user";
	public static String getUser_url=base_url+"/user/{username}";
	public static String updateUser_url=base_url+"/user/{username}";
	public static String deleteUser_url=base_url+"/user/{username}";
	

	//Store Module
	       //Implement store module later
	
	//Pet Module 
	      //Implement pet module later
	
	
}
