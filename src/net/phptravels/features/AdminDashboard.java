package net.phptravels.features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminDashboard {

	private WebDriver testdriver;

	public AdminDashboard(WebDriver driver) {
		testdriver = driver;
	}

	public AdminDashboard toSync(int timeout) {
		testdriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		return this;
	}

	public AdminsPage clickAccounts() {
		WebElement AccountsList = testdriver.findElement(By.cssSelector("a[href*='ACCOUNTS']"));
		AccountsList.click();
		testdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Accounts link clicked");
		return new AdminsPage(testdriver);
	}

	public void clickTours() {
		WebElement ToursList = testdriver.findElement(By.cssSelector("a[@href*='Tours']"));
		ToursList.click();
	}

	public void clickCars() {
		WebElement CarsList = testdriver.findElement(By.cssSelector("a[@href*='Cars']"));
		CarsList.click();
	}

	public void clickHotels() {
		WebElement HotelsList = testdriver.findElement(By.cssSelector("a[@href='Hotels']"));
		HotelsList.click();
	}

}
