package poject1.Demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database_Integrity {
	static String id;
	static String password;
	static 	WebDriver driver;
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");
		

		System.out.println("connected");	

		Statement  smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from employees where employeeNumber=1002;");
	
		while(rs.next())
		{
			id=rs.getString("LastName");
			password=rs.getString("firstName");
			System.out.println("here is table shcema:" +id+ "  " +password);
		}
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "Resource/chromedriver_1.exe");
	    driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys(id);
		Thread.sleep(5000);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(5000);
		driver.quit();
	}

}
