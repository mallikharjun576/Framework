package Sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
  
	@DataProvider(name = "Stringvalues")
	public Object[][] DPMethod()
	{
		return new Object[][] {{"Value1"}, {"Value2"}};
		
	}
	
	@Test(dataProvider = "Stringvalues")
	public void messagePrint(String value)
	{
		System.out.println("Passed parameter is :" +value);
	}
}
