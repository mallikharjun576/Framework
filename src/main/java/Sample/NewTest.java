package Sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(TestNGPractice.ListenerTestNG.class)

public class NewTest {
	
	private WebDriver driver;	
	
	@Test(groups = {"Demo"}, dependsOnMethods="beforeTest")				
	public void testEasy() {	
		driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
	}	
	@Test(priority = -1)
	public void beforeTest() {	
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Maven Project_Jenkins\\lib\\chromedriver.exe");
	    driver = new ChromeDriver();  
	}		
	@Test(dependsOnMethods = "testEasy")
	public void afterTest() {
		driver.quit();			
	}	
}
