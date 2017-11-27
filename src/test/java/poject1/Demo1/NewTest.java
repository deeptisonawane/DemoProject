package poject1.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
  @Test
  public void first() throws InterruptedException 
  {
	driver.manage().window().maximize();
	Thread.sleep(1000);
	driver.findElement(By.id("email")).sendKeys("fsdgsdf");
	Thread.sleep(1000);
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver_1.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.facebook.com/");
	 
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
