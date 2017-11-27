package poject1.Demo1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SecondTest {
  @Test
  public void f1() 
  {
	  System.out.println("Selenium");
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("testng");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("class");
  }

}
