package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {

		super(driver);
	}

	private By signIn = By.cssSelector("[data-test='nav-sign-in']");
	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By submitButton = By.cssSelector(".btnSubmit");
	private By loggedInUserName = By.id("user-menu");
	private By errorMessage = By.cssSelector(".alert");

	public LoginPage goToLoginForm() {

		clickOnElement(signIn);

		return this;
	}

	public LoginPage loginUser(String username, String password) {

		typeInput(emailField, username);
		typeInput(passwordField, password);
		clickOnElement(submitButton);

		return this;
	}

	public String actualLoggedInUser() {

		return getElement(loggedInUserName).getText();
	}

	public boolean isErrorMessagePresent() {

		return wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).isDisplayed();
	}
}
