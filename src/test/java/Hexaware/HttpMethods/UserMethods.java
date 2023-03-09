package Hexaware.HttpMethods;

import static io.restassured.RestAssured.given;

import io.restassured.filter.session.SessionFilter;

public class UserMethods {
	public String createUser(String body, SessionFilter session){
		return given().log().all()
				.header("Content-Type","application/json")
				.body(body)
				.filter(session)
				.when().log().all()
				.post("/user")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
	}
}
