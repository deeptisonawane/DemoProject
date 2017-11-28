package poject1.Demo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TrackoMain {
WebDriver driver;
@Parameters("browser name")
	@BeforeTest
	public void setup(String comingvalues)
	{
		String browser = comingvalues;

		if(browser.equals("chrome"))
		{ System.setProperty("webdriver.chrome.driver", "Resource/chromedriver_1.exe");
		driver = new ChromeDriver();
		}

		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else{
			System.out.println("No browser specified");
		}
		driver.get("https://tracko.co.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void login()
	{
		SignUp s = new SignUp(driver);
		s.SignUp();
	}
	
	@AfterTest
	public void tesrdown()
	{
		driver.quit();
	}
}
