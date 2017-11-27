package poject1.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Web_Table 
{
	WebDriver driver;
  @Test(priority=1)
  public void login_button() throws InterruptedException 
  {
	driver.findElement(By.id("txtUsername")).sendKeys("Admin"); 
	driver.findElement(By.id("txtPassword")).sendKeys("admin");
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(5000);
  }
  
  @Test(priority=2)
  public void admin_button() throws InterruptedException 
  {
	
	driver.findElement(By.xpath("//b[text()='Admin']")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("ohrmList_chkSelectRecord_2")).click();
	driver.findElement(By.id("btnDelete")).click();
	Thread.sleep(5000);
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver_1.exe");
	    driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit(); 
  }

}
