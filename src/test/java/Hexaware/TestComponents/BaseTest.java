package Hexaware.TestComponents;

import Hexaware.HttpMethods.PetMethods;
import Hexaware.HttpMethods.UserMethods;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class BaseTest {
	private static PetMethods petMethods;
	private static UserMethods userMethods;
	private static SessionFilter session;
	
	public BaseTest(){
		this.petMethods = new PetMethods();
		this.userMethods = new UserMethods();
		this.session = new SessionFilter();
	}
	
	public static void initializeWebServiceApp(){
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	public static PetMethods setPetMethods(){
		petMethods = new PetMethods();
		return petMethods;
	}
	
	public static UserMethods setUserMethods(){
		userMethods = new UserMethods();
		return userMethods;
	}
	
	public static SessionFilter setSession(){
		session = new SessionFilter();
		return session;
	}
}
