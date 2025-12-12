package api.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
import api.utilities.DataProviders;

public class UserTestDD {

	@Test(priority = 1, dataProvider = "alldata", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName,String fname ,String lname, String email, String pwd, String phone) {
		
		User userPayload = new User();	
		
		userPayload.setId(Integer.parseInt(userId)); //hashcode for uniqueness
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3, dataProvider = "usernamesdata", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		
		Response response = UserEndPoints.deleteUser(username);
		
		System.out.println("Delete User Data");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "usernamesdata", dataProviderClass = DataProviders.class)
	public void testGetUser(String username) {
		
		Response response = UserEndPoints.getUser(username);
		
		System.out.println("Delete User Data");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
