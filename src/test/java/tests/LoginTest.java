package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	@BeforeMethod
	public void setLoginPage() {

		loginPage = new LoginPage(driver);
	}
}
