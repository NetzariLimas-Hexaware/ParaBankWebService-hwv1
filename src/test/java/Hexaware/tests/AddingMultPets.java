package Hexaware.tests;

import Hexaware.TestComponents.BaseTest;
import Hexaware.data.AddDelPetsData;
import Hexaware.utils.JsonConverter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class AddingMultPets extends BaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize
		initializeWebServiceApp();
		SessionFilter session = setSession();
		//
		
		// Add a pet
				String response = setPetMethods().AddNewPetToStore(AddDelPetsData.addPetBody());
				JsonPath responseJson = JsonConverter.RawToJson(response);		
				String petId = responseJson.getString("id");
				System.out.println(response);
				
				// Find the status of the pet added as available
				response = setPetMethods().FindPetsByStatus("available");
				responseJson = JsonConverter.RawToJson(response);
				
				// Get count of total available pets
				int totAvailablePets = responseJson.getInt("size()");
				System.out.println("Total pets: " + totAvailablePets);
				
				// Order a pet
				
				response = setPetMethods().PlaceAnOrderForAPet(AddDelPetsData.placePetOrder());
				responseJson = JsonConverter.RawToJson(response);
				System.out.println(responseJson);
				
				// Get total count of pets with "shipDate" as current date //
				// API NOT AVAILABLE //
				
				// Delete the pet recently added
				response = setPetMethods().DeletePet(petId, session);
				responseJson = JsonConverter.RawToJson(response);
				
				// Get count of remaining available pets
				response = setPetMethods().FindPetsByStatus("available");
				responseJson = JsonConverter.RawToJson(response);
				
				// Get count of total available pets
				int remAvailablePets = responseJson.getInt("size()");
				System.out.println("Remain pets: " + remAvailablePets);
	}

}
