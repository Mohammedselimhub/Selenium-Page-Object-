package testdata;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bsh.ParseException;

public class JsonDataReader {

	public String email, password; 

	public void JsonReader() throws IOException, ParseException, org.json.simple.parser.ParseException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/testdata/UserData.json";

		File sourceFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(sourceFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject person = (JSONObject) jsonObj ; 
			email = (String) person.get("email"); 
			System.out.println(email);
			password = (String) person.get("password"); 
			System.out.println(password);
		}
	}
}
