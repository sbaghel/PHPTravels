package net.phptravels.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import net.phptravels.features.AdminLoginPage;

public class NewAdmin {

@Test
public void Test1() throws IOException{
	
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

		new AdminLoginPage(driver).geturl(URL).userLogin(Username, Password).toSync(5).clickAccounts().clickAdmins().addAdmins()
				.enterAdmindetails(FirstName, LastName, NewAdminEmail, NewAdminPassword, MobileNo, Country,
						AddressLine1, AddressLine2)
				.selectStatus("Enabled").selectPrivileges1().submitUser().deleteUser();

	}

}
