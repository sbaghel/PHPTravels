package net.phptravels.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import net.phptravels.features.AdminDashboard;
import net.phptravels.features.AdminLoginPage;
import net.phptravels.features.AdminsPage;

public class login {
	
	@Test
	public void testing() throws IOException{
	//public static void main(String[] args) throws IOException {

		File file = new File("D:\\My Stuff\\Java Learning\\PHPTravels\\Properties\\config.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
		String URL = prop.getProperty("address");
		String Username = prop.getProperty("email");
		String Password = prop.getProperty("pswd");
		String FirstName = prop.getProperty("fn");
		String LastName = prop.getProperty("ln");
		String NewAdminEmail = prop.getProperty("email2");
		String NewAdminPassword = prop.getProperty("pwd");
		String MobileNo = prop.getProperty("mobileno");
		String Country = prop.getProperty("ctry");
		String AddressLine1 = prop.getProperty("Add1");
		String AddressLine2 = prop.getProperty("Add2");
		
		
		 
		
		
		WebDriver driver = new FirefoxDriver();

		// Creating objects for classes
		AdminLoginPage LoginObj = new AdminLoginPage(driver);
		AdminDashboard DashboardObj = new AdminDashboard(driver);
		AdminsPage AdminObj = new AdminsPage(driver);

		// Calling login page methods
		LoginObj.geturl(URL);		
		LoginObj.userLogin(Username, Password);
		DashboardObj.toSync(5);
		LoginObj.urlCompare();

		// Calling Dashboard methods
		DashboardObj.toSync(10);
		DashboardObj.clickAccounts();

		// Calling Administrator page methods
		AdminObj.clickAdmins();
		DashboardObj.toSync(5);
		String actualurl1 = driver.getCurrentUrl();
		System.out.println("Extension of current url is : " + actualurl1.substring(actualurl1.indexOf("net/") + 4));
		AdminObj.addAdmins();
		DashboardObj.toSync(5);
		String actualurl2 = driver.getCurrentUrl();
		System.out.println("Extension of current url is : " + actualurl2.substring(actualurl2.indexOf("net/") + 4));
		AdminObj.enterAdmindetails(FirstName, LastName, NewAdminEmail, NewAdminPassword, MobileNo, Country, AddressLine1, AddressLine2);
		AdminObj.selectStatus("Enabled");
		AdminObj.selectPrivileges1();
		AdminObj.submitUser();
		AdminObj.deleteUser();
		LoginObj.logout();
		LoginObj.closebrowser();
	}

}
