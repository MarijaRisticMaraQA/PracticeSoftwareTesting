package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Utils;

import java.time.Duration;

public class DriverManager {

	private static String browser = Utils.dotenv().get("BROWSER");
	public static WebDriver setDriver() {

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		return driver;
	}

}
