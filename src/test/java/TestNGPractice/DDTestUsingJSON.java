package TestNGPractice;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DDTestUsingJSON {
	
	WebDriver driver;
	
  @BeforeClass
  public void setup() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
  }
  @AfterClass
  public void teardown() {
	  
	  driver.close();
  }
  
  @Test(dataProvider = "dp")
  void login(String data)
  {		
	  String users[] = data.split(",");
	  
	  driver.get("https://demo.nopcommerce.com/login");
	  driver.findElement(By.id("Email")).sendKeys(users[0]); //username
	  driver.findElement(By.id("Password")).sendKeys(users[1]); //password
	  
	  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	  
	 String actualTitle =  driver.getTitle();
	 String expTitle = "nopCommerce demo store";
	 Assert.assertEquals(expTitle, actualTitle);
  }
  
  @DataProvider(name = "dp")
 public String[] readJson() throws IOException, ParseException
  {
	  JSONParser parser = new JSONParser();
	  
	  FileReader reader = new FileReader(".\\JSonFiles\\testdata.json");
	  
	  Object obj = parser.parse(reader);
	  
	  JSONObject data = (JSONObject)obj;
	  
	  JSONArray dataarray = (JSONArray) data.get("userlogins");
	  
	  String arr[] = new String[dataarray.size()];
	  
	  for(int i=0; i<dataarray.size(); i++)
	  {
		  JSONObject userdata = (JSONObject) dataarray.get(i);
		  String user = (String) userdata.get("username");
		  String pwd = (String) userdata.get("password");
		  arr[i] = user+","+pwd ;	
	  }
	  
	  return arr;
  }
}
