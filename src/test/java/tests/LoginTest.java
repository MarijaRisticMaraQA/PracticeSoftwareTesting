package tests;

import dataproviders.LoginDataProviders;
import model.LoginUserModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Utils;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	RegisterPage registerPage;
	private String firstName = "Jane";
	private String lastName = "Doe";
	@BeforeMethod
	public void setLoginPage() {

		loginPage = new LoginPage(driver);
		registerPage = new RegisterPage(driver);
	}

	@Test(description = "Login user")
	public void loginUserTest() {

		loginPage.goToLoginForm()
				.loginUser("customer@practicesoftwaretesting.com", "welcome01");

		String expectedLoggedInUser = firstName + " " + lastName;
		Assert.assertEquals(loginPage.actualLoggedInUser(), expectedLoggedInUser, "User name is not matching");
		assertTrue(registerPage.isUserRegisteredAndLoggedIn());
	}

	@Test(description = "Negative test: Login user",
	dataProvider = "loginProvider",
			dataProviderClass = LoginDataProviders.class)
	public void invalidLoginTest(String username, String password) {

		loginPage.goToLoginForm()
				.loginUser(username, password);

		assertTrue(loginPage.isErrorMessagePresent());
	}
	@Test
	public void invalidLoginTestFromJson() {

		List<LoginUserModel> list = Utils.getDataFromJson();
		for (int i = 0; i < list.size(); i++) {

			loginPage.goToLoginForm()
					.loginUser(list.get(i).getUsername(), list.get(i).getPassword());
		}
		assertTrue(loginPage.isErrorMessagePresent());
	}
}
