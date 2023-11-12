package pages;

import model.RegisterUserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

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
	private By myAccountPageTitle = By.cssSelector("[data-test='page-title']");
	private By profileInMenu = By.cssSelector("[data-test='nav-profile']");

	public RegisterPage goToRegisterPage() {
		clickOnElement(signIn);
		clickOnElement(registerAccButton);

		return this;
	}

	public RegisterPage registerUser() {

		username = faker.internet().emailAddress();
		password = faker.internet().password();
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();

		typeInput(firstNameField, firstName);
		typeInput(lastNameField, lastName);
		typeInput(dateOfBirthField, birthInput());
		typeInput(addressField, faker.address().streetAddress());
		typeInput(postcodeField, faker.address().zipCode());
		typeInput(cityField, faker.address().city());
		typeInput(stateField, faker.address().country());
		selectCountry();
		typeInput(phoneField, faker.number().digits(8));
		typeInput(emailField, username);
		typeInput(passwordField, password);

		clickOnElement(submitButton);
		Utils.waitForSeconds(1);

		return this;
	}

	public RegisterPage registerNewUser() {

		RegisterUserModel user = Utils.gerDataFromJson();

		username = user.getUsername();
		password = user.getPassword();

		typeInput(firstNameField, user.getFirstName());
		typeInput(lastNameField, user.getLastName());
		typeInput(dateOfBirthField, birthInput());
		typeInput(addressField, user.getAddress());
		typeInput(postcodeField, user.getPostcode());
		typeInput(cityField, user.getCity());
		typeInput(stateField, user.getState());
		selectCountry();
		typeInput(phoneField, user.getPhone());
		typeInput(emailField, username);
		typeInput(passwordField, password);

		clickOnElement(submitButton);
		Utils.waitForSeconds(1);

		return this;
	}

	public RegisterPage registerNewFakerUser() {

		RegisterUserModel register = new RegisterUserModel();

		username = register.getUsername();
		password = register.getPassword();

		typeInput(firstNameField, register.getFirstName());
		typeInput(lastNameField, register.getLastName());
		typeInput(dateOfBirthField, birthInput());
		typeInput(addressField, register.getAddress());
		typeInput(postcodeField, register.getPostcode());
		typeInput(cityField, register.getCity());
		typeInput(stateField, register.getState());
		selectCountry();
		typeInput(phoneField, register.getPhone());
		typeInput(emailField, username);
		typeInput(passwordField, password);

		clickOnElement(submitButton);
		Utils.waitForSeconds(1);
		return this;
	}

	private void selectCountry() {


		Select objSelect = new Select(getElement(countryDropdown));
		objSelect.selectByVisibleText("Serbia");
	}

	private String birthInput() {

		if (driver instanceof ChromeDriver) {
			return "11111911";
		} else if (driver instanceof FirefoxDriver) {
			return "11/11/1911";
		} else if (driver instanceof EdgeDriver) {
			return "11/11/1911";
		}
		return null;
	}

	public void assertLoggedInUser() {

		String actualLoggedInUser = getElement(loggedInUserName).getText();
		String expectedLoggedInUser = firstName + " " + lastName;

		assertEquals(actualLoggedInUser, expectedLoggedInUser, "Users are not matching");
	}

	public boolean isUserRegisteredAndLoggedIn() {

		return matchesExpectedText(myAccountPageTitle, "My account")
				&& matchesExpectedText(profileInMenu, "Profile");
	}

	public String getUsername() {

		return username;
	}

	public String getPassword() {

		return password;
	}
}
