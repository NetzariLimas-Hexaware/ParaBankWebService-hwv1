package Hexaware.data;

public class AddDelPetsData {
	public static String addPetBody(){
		return "{\"id\":0,\"category\":{\"id\":0,\"name\":\"string\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"string\"}],\"status\":\"available\"}";
	}
	
	public static String createUserBody(){
		return "{\"id\":0,\"username\":\"string\",\"firstName\":\"string\",\"lastName\":\"string\",\"email\":\"string\",\"password\":\"string\",\"phone\":\"string\",\"userStatus\":0}";
	}
	
	public static String placePetOrder(){
		return "{\"id\":0,\"petId\":0,\"quantity\":0,\"shipDate\":\"2023-03-13T17:18:45.972+0000\",\"status\":\"placed\",\"complete\":true}";
	}
}
