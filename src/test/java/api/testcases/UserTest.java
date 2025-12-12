package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;	//for setting fake data to payload
	
	@BeforeClass 	//to execute before all methods of class
	public void generateTestData() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode()); //hashcode for uniqueness
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());		
	} 
	
	@Test(priority = 1)
	public void testCreateUser() {
		
		Response response = UserEndPoints.createUser(userPayload);
		
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testGetUser() {
		
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		
		System.out.println("Read User Data");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		userPayload.setFirstName(faker.name().firstName());//update firstName
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.statusCode(), 200);
		
		//Read user data to check if firstname updated
		Response responsePostUpdate = UserEndPoints.getUser(this.userPayload.getUsername());
		
		System.out.println("After Update User Data");
		responsePostUpdate.then().log().all();
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		System.out.println("Delete User Data");
		//log response
		response.then().log().all();
		
		//validation
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}


















