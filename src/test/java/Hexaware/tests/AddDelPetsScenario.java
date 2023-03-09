// 2.2.1	Addition and deletion of the Pets
// In this scenario, the customer should be do following the 
// -	Add pet to pet store 
// -	Delete the pet recently added
// -	Validate the Pet if it’s got deleted.

package Hexaware.tests;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import Hexaware.TestComponents.BaseTest;
import Hexaware.data.AddDelPetsData;
import Hexaware.utils.JsonConverter;

public class AddDelPetsScenario extends BaseTest {

	public static void main(String[] args) {
		
		// Initialize
		initializeWebServiceApp();
		SessionFilter session = setSession();
		//
		
		// Add a pet
		String response = setPetMethods().AddNewPetToStore(AddDelPetsData.addPetBody());
		JsonPath responseJson = JsonConverter.RawToJson(response);		
		String petId = responseJson.getString("id");
		System.out.println(response);
		
		// We have to create an user to have an access and a token
		response = setUserMethods().createUser(AddDelPetsData.createUserBody(), session);
		System.out.println(response);
		// Then delete the pet
		
		response = setPetMethods().DeletePet(petId, session);
		System.out.println(response);
		
		// Done first scenario
	}

}
