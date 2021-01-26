package TestNGPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class ReadDataFromJson {
  @Test
  public void readJsonData() throws IOException, ParseException {
	  
	  JSONParser jsonparser = new JSONParser();
	  FileReader reader = new FileReader(".\\JSonFiles\\student.json");
	  
	  Object obj = jsonparser.parse(reader);
	  
	  JSONObject studentjsonobj = (JSONObject)obj;
	  
	  String fNanme = (String) studentjsonobj.get("firstname");
	  String lNanme = (String) studentjsonobj.get("lastname");
	  
	  System.out.println("First name read from Json File is: " +fNanme);
	  System.out.println("Last name read from Json File is: " +lNanme);
	  
	  JSONArray jsonarray = (JSONArray) studentjsonobj.get("address");
	  
	  for(int i=0; i<jsonarray.size(); i++)
	  {
		  JSONObject address = (JSONObject)jsonarray.get(i);
		  
		  String street = (String) address.get("Street");
		  String city = (String) address.get("city");
		  String state = (String) address.get("state");
		  
		  System.out.println("Address of Json Array "+i+" is...........");
		  System.out.println("street: " +street);
		  System.out.println("city: " +city);
		  System.out.println("state: " +state);
	  }
  }
}
