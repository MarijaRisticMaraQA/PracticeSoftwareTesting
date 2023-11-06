package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class RegisterPage extends BasePage{

	public RegisterPage(WebDriver driver) {

		super(driver);
	}

	private String username;
	private String password;
	private String firstName;
	private String lastName;

	private By signIn = By.cssSelector("[data-test='nav-sign-in']");
	private By registerAccButton = By.cssSelector("[data-test='register-link']");
	private By firstNameField = By.id("first_name");
	private By lastNameField = By.id("last_name");
	private By dateOfBirthField = By.id("dob");
	private By addressField = By.id("address");
	private By postcodeField = By.id("postcode");
	private By cityField = By.id("city");
	private By stateField = By.id("state");
	private By countryDropdown = By.id("country");
	private By phoneField = By.id("phone");
	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By submitButton = By.cssSelector(".btnSubmit");
	private By loggedInUserName = By.id("user-menu");

	public RegisterPage goToRegisterPage() {
		clickOnElement(signIn);
		clickOnElement(registerAccButton);

		return this;
	}

	public RegisterPage registerPage() {

		username = faker.internet().emailAddress();
		password = faker.internet().password();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();

		typeInput(firstNameField, firstName);
		typeInput(lastNameField, lastName);
		typeInput(dateOfBirthField, "11.11.1911");
		typeInput(addressField, faker.address().streetAddress());
		typeInput(postcodeField, faker.address().zipCode());
		typeInput(cityField, faker.address().city());
		typeInput(stateField, faker.address().country());
		selectCountry();
		typeInput(phoneField, faker.number().digits(8));
		typeInput(emailField, username);
		typeInput(passwordField, password);

		clickOnElement(submitButton);

		return this;
	}

	private void selectCountry() {

		Select objSelect = new Select(getElement(countryDropdown));
		objSelect.selectByVisibleText("Serbia");
	}

	public void loginUser() {

		clickOnElement(signIn);
		typeInput(emailField, username);
		typeInput(passwordField, password);
		clickOnElement(submitButton);
	}

	public void assertLoggedInUser() {

		String actualLoggedInUser = getElement(loggedInUserName).getText();
		String expectedLoggedInUser = firstName + " " + lastName;

		assertEquals(actualLoggedInUser, expectedLoggedInUser, "Users are not matching");
	}
}
