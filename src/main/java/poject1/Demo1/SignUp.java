package poject1.Demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp {
WebDriver driver;
	
	public SignUp(WebDriver driver2) {
	driver= driver2;
}

	public void SignUp()
	{
		WebElement signup= driver.findElement(By.xpath("//a [text()='Sign Up Free']"));
		signup.click();
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("priyanka");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("abc@gmail.com");
		
		WebElement mobile = driver.findElement(By.id("mobile"));
		mobile.sendKeys("9403587347");
		
		WebElement button = driver.findElement(By.id("sub_btn_signup"));
		button.click();
	}
}
