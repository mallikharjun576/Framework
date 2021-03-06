package TestNGPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationTest {
  @Test
  public void Test1() {
	  System.out.println("in Test1 Method");
  }
  @Test
  public void Test2() {
	  System.out.println("in Test2 Method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("in Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("in After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("in Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("in After class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("in Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("in After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("in Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("in After Suite");
  }

}
