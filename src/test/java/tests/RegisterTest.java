package tests;

import listeners.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

import static org.testng.Assert.assertTrue;
@Listeners(TestListener.class)
public class RegisterTest extends BaseTest{

	RegisterPage registerPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUpRegister() {

		registerPage = new RegisterPage(driver);
		loginPage = new LoginPage(driver);
	}
	@Test(description = "Registering user")
	public void registerTest() throws InterruptedException {

		registerPage.goToRegisterPage()
				.registerUser();
		loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());
		registerPage.assertLoggedInUser();
		assertTrue(registerPage.isUserRegisteredAndLoggedIn(), "User is not registered");
	}

	@Test
	public void registerTestFromJson() {

		registerPage.goToRegisterPage()
				.registerNewUser();
		loginPage.loginUser(registerPage.getUsername(), registerPage.getPassword());
		assertTrue(registerPage.isUserRegisteredAndLoggedIn(), "User is not registered");
	}
}
