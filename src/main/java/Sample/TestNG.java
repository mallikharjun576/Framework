package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(TestNGPractice.ListenerTestNG.class)
public class TestNG {
	WebDriver driver;
    // Saving the expected title of the Webpage
    String title = "ToolsQA - Demo Website For Automation";
    
   
    @Test(priority = -1, groups = { "demo1" })
    public void openBrowser(){
     System.out.println("This is the starting point of the test");
     
     WebDriverManager.chromedriver().setup();
     //System.setProperty("webdriver.chrome.driver", "C:\\Eduarte\\Learning Automation\\chromedriver.exe");
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     driver.get("https://www.abhibus.com/");
    }
    
    
    @Test(groups = { "demo1" }, dependsOnMethods = {"openBrowser"}) 
    public void checkTitle() { 
       String testTitle = "Bus Ticket Booking | Book Bus Ticket Online - Save Rs. 500 with Abhibus";
       String originalTitle = driver.getTitle();
      Assert.assertEquals(originalTitle, testTitle);
    } 
    
    @Test(groups = { "demo2" }, dependsOnMethods = {"openBrowser", "checkTitle"} ) 
    public void click_element() { 
       driver.findElement(By.xpath("//*[@class=\"nav-link\" and text()=\"Get Free Rides\"]")).click();
        System.out.println("Home Page heading is displayed"); 
    }
    @Test(priority=2)
    public void closeBrowser() {
    	driver.close();
    }
}
