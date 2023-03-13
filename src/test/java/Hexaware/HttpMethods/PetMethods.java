package Hexaware.HttpMethods;

import static io.restassured.RestAssured.given;

import io.restassured.filter.session.SessionFilter;

public class PetMethods {
	public String AddNewPetToStore(String body){
		return given().log().all()
		.header("Content-Type","application/json")
		.body(body)
		.when().log().all().post("/pet")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
	}
	
	public String DeletePet(String petId, SessionFilter session){
		return given().log().all()
				.header("Content-Type","application/json")
				.pathParam("petId", petId)
				.filter(session)
				.when().log().all()
				.delete("/pet/{petId}")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
	}
	
	public String FindPetsByStatus(String status){
		return given()
				.log().all()
				.header("Content-Type","application/json")
				.queryParam("status", status)
				.when()
				.log().all()
				.get("/pet/findByStatus")
				.then()
				.log().all()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}
	
	public String PlaceAnOrderForAPet(String petBody){
		return given()
				.log().all()
				.header("Content-type", "application/json")
				.body(petBody)
				.when()
				.log().all()
				.post("/store/order")
				.then()
				.log().all()
				.assertThat().statusCode(200)
				.extract().response().asString();
	}
}
