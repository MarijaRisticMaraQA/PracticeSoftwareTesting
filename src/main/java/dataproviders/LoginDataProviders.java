package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProviders {

	@DataProvider(name = "loginProvider")
	public Object[][] loginProvider() {
		return new Object[][] {
				{"", ""},
				{"username1", ""},
				{"", "password1"},
				{"bla.bla.com", "welcome01"},
				{"customer@practicesoftwaretesting.com", "12"},
				{"customer@practicesoftwaretesting.com", "123"}
		};
	}
}
