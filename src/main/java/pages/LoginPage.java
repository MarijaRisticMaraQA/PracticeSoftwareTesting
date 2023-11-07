package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	private String email = "customer@practicesoftwaretesting.com";
	private String password = "welcome01";
	private String firstName = "Jane";
	private String lastName = "Doe";

	private By signIn = By.cssSelector("[data-test='nav-sign-in']");
	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By submitButton = By.cssSelector(".btnSubmit");
	private By loggedInUserName = By.id("user-menu");

	public void loginUser() {

		clickOnElement(signIn);
		typeInput(emailField, email);
		typeInput(passwordField, password);
		clickOnElement(submitButton);
	}

	public void assertLoggedInUser() {

		String actualLoggedInUser = getElement(loggedInUserName).getText();
		String expectedLoggedInUser = firstName + " " + lastName;

		assertEquals(actualLoggedInUser, expectedLoggedInUser, "Users are not matching");
	}
}
