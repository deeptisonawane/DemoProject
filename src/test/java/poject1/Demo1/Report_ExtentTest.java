package poject1.Demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report_ExtentTest {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	By locator_userName=By.id("txtUsername");
	By locator_password=By.id("txtPassword");
	By locator_loginButton=By.id("btnLogin");
	
	private String dashboradURL="http://opensource.demo.orangehrmlive.com/index.php/dashboard";
	
  @Test
  public void f() 
  {
	  try 
		{
			WebElement username=driver.findElement(locator_userName);
			username.sendKeys("Admin");
			test.log(Status.PASS, "Username entered Successfully");
		}
		catch (Exception e) 
		{
			test.log(Status.FAIL, "Something went wrong in Username");
		}
		try 
		{
			WebElement password=driver.findElement(locator_password);
			password.sendKeys("admin");

			test.log(Status.PASS, "Password entered Successfully");
		} catch (Exception e) 
		{
			test.log(Status.FAIL, "Something went wrong in Password");
		}

		try 
		{
			WebElement loginBtn=driver.findElement(locator_loginButton);
			loginBtn.click();
			test.log(Status.PASS, "Login button is working fine");
		} catch (Exception e) 
		{
			test.log(Status.FAIL, "Something went wrong with Login button");
		}

		if (driver.getCurrentUrl().equals(dashboradURL)) {
			test.log(Status.PASS, "I have loged in Succssfully");		
		}
		else
		{
			test.log(Status.FAIL, "I am still in Login Page");
		}

	}


  
  @BeforeTest
  public void beforeTest() 
  {
	  htmlReporter = new ExtentHtmlReporter("extent.html");
	  extent= new ExtentReports();
		extent.attachReporter(htmlReporter);

		test = extent.createTest("Selenium Test");
	  
	  
		try {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver_1.exe");
			driver= new ChromeDriver();
			test.log(Status.PASS, "My browser got initiated");

			driver.navigate().to("http://opensource.demo.orangehrmlive.com/");
			test.log(Status.PASS, "My Site got opened");

		} catch (Exception e) {
			test.log(Status.FAIL, "Something went wrong in Before Test");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



	}


  @AfterTest
  public void afterTest() 
  {
	  extent.flush();
	  driver.quit();
  }

}
