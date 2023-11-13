package tests;

import org.example.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	@BeforeMethod
	public void setUp () {

		driver = DriverManager.setDriver();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		driver.get("https://practicesoftwaretesting.com/#/");
	}
}