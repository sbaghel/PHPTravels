package net.phptravels.features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AdminLoginPage {

	private WebDriver testdriver;

	public AdminLoginPage(WebDriver driver) {
		testdriver = driver;
	}

	/*public void geturl(String address) {
		testdriver.get(address);
		testdriver.manage().window().maximize();
		System.out.println("Navigated to PHP Travels");
	}*/

	@BeforeSuite
	public AdminLoginPage geturl(String address) {
		testdriver.get(address);
		testdriver.manage().window().maximize();
		System.out.println("Navigated to PHP Travels");
		return this;
	}

	@BeforeClass
	public AdminDashboard userLogin(String email, String pswd) {
		WebElement username = testdriver.findElement(By.name("email"));
		WebElement password = testdriver.findElement(By.name("password"));
		WebElement submit = testdriver.findElement(By.xpath("//div/button[@type='submit']"));
		username.sendKeys(email);
		password.sendKeys(pswd);
		submit.click();
		testdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Login Successfull");
		return new AdminDashboard(testdriver);
	}

	/*
	 * public void enterPassword(String pswd){ WebElement password =
	 * testdriver.findElement(By.name("password")); password.sendKeys(pswd);
	 * System.out.println("Password entered"); }
	 * 
	 * public void clickSignIn(){ WebElement submit =
	 * testdriver.findElement(By.xpath("//div/button[@type='submit']"));
	 * submit.click(); System.out.println("Submit button clicked"); }
	 */
	@Test
	public String urlCompare() {
		String expectedurl = "http://phptravels.net/admin";
		String actualurl = testdriver.getCurrentUrl();
		if (actualurl.equals(expectedurl)) {
			System.out.println(actualurl + " - is same as - " + expectedurl);
		} else {
			System.out.println(actualurl + " - is not same as - " + expectedurl);
		}
		return actualurl;
	}
	
	@AfterClass
	public void logout(){
		WebElement select = testdriver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
		Actions act = new Actions(testdriver);
		act.moveToElement(select).build().perform();
		select.click();
		testdriver.findElement(By.cssSelector("a[href*='admin/logout']")).click();
		System.out.println("LogOut successful");
	}
	
	@AfterSuite
	public void closebrowser() {
		testdriver.close();
		System.out.println("Browser Closed");
		
	}
}
