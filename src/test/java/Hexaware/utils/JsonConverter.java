package Hexaware.utils;

import io.restassured.path.json.JsonPath;

public class JsonConverter {
	static JsonPath json;
	public static JsonPath RawToJson(String text){
		json = new JsonPath(text);
		return json;
	}
}
