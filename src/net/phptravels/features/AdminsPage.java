package net.phptravels.features;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminsPage {

	private WebDriver testdriver;

	public AdminsPage(WebDriver driver) {
		testdriver = driver;
	}
	
	public AdminsPage clickAdmins() {
		WebElement Admins = testdriver.findElement(By.cssSelector("a[href*='admins']"));
		Admins.click();
		testdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Admins link clicked");
		return this;
	}

	public AdminsPage addAdmins() {
		WebElement newAdmin = testdriver.findElement(By.cssSelector("button[type*='submit']"));
		newAdmin.click();
		testdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Add new admin button clicked");
		return this;
	}

	public AdminsPage enterAdmindetails(String fn, String ln, String email, String pwd, String mobileno, String ctry,
			String Add1, String Add2) {
		WebElement fname = testdriver.findElement(By.name("fname"));
		fname.sendKeys(fn);
		WebElement lname = testdriver.findElement(By.name("lname"));
		lname.sendKeys(ln);
		WebElement useremail = testdriver.findElement(By.name("email"));
		useremail.sendKeys(email);
		WebElement userPassword = testdriver.findElement(By.name("password"));
		userPassword.sendKeys(pwd);
		WebElement userMobile = testdriver.findElement(By.name("mobile"));
		userMobile.sendKeys(mobileno);
		Select cselect = new Select(testdriver.findElement(By.cssSelector("select[name*='country']")));
		// List<WebElement> allOptions = cselect.getOptions();
		cselect.selectByVisibleText(ctry);
		WebElement Address1 = testdriver.findElement(By.name("address1"));
		Address1.sendKeys(Add1);
		WebElement Address2 = testdriver.findElement(By.name("address2"));
		Address2.sendKeys(Add2);
		System.out.println("User details entered");
		return this;
	}

	/*
	 * public void enterLastname(String ln){ WebElement lname =
	 * testdriver.findElement(By.name("lname")); lname.sendKeys(ln); }
	 * 
	 * public void enterEmail(String email){ WebElement useremail =
	 * testdriver.findElement(By.name("email")); useremail.sendKeys(email); }
	 * 
	 * public void enterPassword(String pwd){ WebElement userPassword =
	 * testdriver.findElement(By.name("password")); userPassword.sendKeys(pwd);
	 * }
	 * 
	 * public void enterMobile(String mobileno){ WebElement userMobile =
	 * testdriver.findElement(By.name("mobile")); userMobile.sendKeys(mobileno);
	 * }
	 * 
	 * public void selectCountry(String ctry){ Select cselect = new
	 * Select(testdriver.findElement(By.cssSelector("select[name*='country']")))
	 * ; //List<WebElement> allOptions = cselect.getOptions();
	 * cselect.selectByVisibleText(ctry); }
	 * 
	 * public void enterAddress1(String Add1){ WebElement Address1 =
	 * testdriver.findElement(By.name("address1")); Address1.sendKeys(Add1); }
	 * 
	 * public void enterAddress2(String Add2){ WebElement Address2 =
	 * testdriver.findElement(By.name("address2")); Address2.sendKeys(Add2); }
	 */

	public AdminsPage selectStatus(String status) {
		Select statusSelect = new Select(testdriver.findElement(By.name("status")));
		// List<WebElement> allOptions = cselect.getOptions();
		statusSelect.selectByVisibleText(status);
		System.out.println("Status of Administrator selected");
		return this;
	}

	/*
	 * public void selectPriviledges() { testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='addtours']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='addcars']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='addhotels']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='edittours']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='editcars']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='edithotels']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='deletetours']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='deletecars']")).sendKeys(Keys.SPACE);
	 * testdriver.findElement(By.cssSelector(
	 * "input[class*='checkbox'][value='deletehotels']")).sendKeys(Keys.SPACE);
	 * }
	 */

	public AdminsPage selectPrivileges1() {
		List<WebElement> allcheckboxes = testdriver.findElements(By.xpath("//div[@class='col-md-4']//input[@class='checkbox']"));
		
		for (int i = 0; i < allcheckboxes.size(); i++) {
			String value  = allcheckboxes.get(i).getAttribute("value");
			
			String value1 = "addtours";
			
			if (!value.equals(value1)){
			testdriver.findElements(By.xpath("//div[@class='row']/div/div/div/ul/li/label/div/input[@class='checkbox']")).get(i).sendKeys(Keys.SPACE);
			}
		}
		System.out.println("Required privileges to Administrator assigned");
		return this;
	}

	public AdminsPage submitUser() {
		testdriver.findElement(By.xpath("//div/button[@class='btn btn-primary']")).click();
		testdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Administrator added successfully");
		return this;
	}

	/*
	 * public void selectUser(){ testdriver.findElement(By.cssSelector(
	 * "input[class*='checkboxcls'][type='checkbox']")).sendKeys(Keys.SPACE); }
	 */

	public AdminsPage deleteUser() {
		testdriver.findElement(By.cssSelector("input[class*='checkboxcls'][type='checkbox']")).sendKeys(Keys.SPACE);
		testdriver.findElement(By.cssSelector("a[class*='btn btn-danger']")).click();
		Alert alert = testdriver.switchTo().alert();
		alert.accept();
		String message = testdriver.findElement(By.xpath("//tr[@class='xcrud-row']")).getText();
		System.out.println(message + " : i.e. Admin user deleted successfully");
		return this;
	}

	/*
	 * public void handleAlert(){ Alert alert = testdriver.switchTo().alert();
	 * alert.accept(); String message =
	 * testdriver.findElement(By.xpath("//tr[@class='xcrud-row']")).getText();
	 * System.out.println(message+ " : i.e. Admin user deleted successfully"); }
	 */
}
