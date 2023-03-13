package Hexaware.tests;

import Hexaware.TestComponents.BaseTest;
import Hexaware.data.AddDelPetsData;
import Hexaware.utils.JsonConverter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class GetTotNumAvaPets extends BaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize
			initializeWebServiceApp();
			SessionFilter session = setSession();
		//
			
		// Create a pet
			String response = setPetMethods().AddNewPetToStore(AddDelPetsData.addPetBody());
			JsonPath responseJson = JsonConverter.RawToJson(response);		
			String petId = responseJson.getString("id");
//			System.out.println(response);
			
		// Find the status of the pet added as available
			response = setPetMethods().FindPetsByStatus("available");
			responseJson = JsonConverter.RawToJson(response);
			
			int totAvailablePets = responseJson.getInt("size()");
			System.out.println("Total pets: " + totAvailablePets);
			
		// Delete the pet recently added
			
			response = setPetMethods().DeletePet(petId, session);
			responseJson = JsonConverter.RawToJson(response);
//			System.out.println(responseJson);
			
			// Check again for available pets
			response = setPetMethods().FindPetsByStatus("available");
			responseJson = JsonConverter.RawToJson(response);
			int remTotAvailablePets = responseJson.getInt("size()");
			System.out.println("Remaining Pets:" + remTotAvailablePets);
			
			int dif = totAvailablePets - remTotAvailablePets;
			if(dif == 1)
				System.out.println("Second scenario done.");
	}

}
