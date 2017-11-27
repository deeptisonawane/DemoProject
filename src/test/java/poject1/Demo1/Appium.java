package poject1.Demo1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Appium 
{
	WebDriver driver;
  @Test ()
  public void f() throws InterruptedException 
  {
	  
	  driver.findElement(By.name("txtUsername")).sendKeys("admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("Submit")).click();
		
  }
  
  @Test (enabled=false)
  public void f1() throws InterruptedException
  {
	  Thread.sleep(5000);
		WebElement loginID=driver.findElement(By.id("com.demo.amanora:id/loginGold"));
		loginID.click();
		Thread.sleep(5000);
		WebElement storelist = driver.findElement(By.id("com.demo.amanora:id/storesLayout"));
		storelist.click();
		Thread.sleep(5000);
		
  }
  
  
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException 
  {
	  //File app=new File("Resource/TheMallApp(1).apk");
	  
	  String deviceName="";
	  if (deviceName.equals("mobile")) 
	  {
		  
		  DesiredCapabilities desiredCapabilities=DesiredCapabilities.android();
			desiredCapabilities.setCapability("browserName", "chrome");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "6.0.1");
			desiredCapabilities.setCapability("deviceName", "Moto G Tarbo");
			driver= new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		
	}
	  else if (deviceName.equals("browser")) 
	  {
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver_1.exe");
		driver = new ChromeDriver();
			
		    
		  
	}
			
	  driver.get("http://opensource.demo.orangehrmlive.com/");
	  
		
  }

  @AfterTest
  public void afterTest() 
  {
	driver.quit();
  }

}
