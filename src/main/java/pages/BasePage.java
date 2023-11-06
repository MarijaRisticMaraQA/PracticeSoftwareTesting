package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	Faker faker;

	public BasePage (WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		faker = new Faker();
	}

	protected WebElement getElement(By locator) {

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected List<WebElement> getListOfWebElements(By locator) {

		return driver.findElements(locator);
	}

	protected void typeInput(By locator, String text) {

		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	protected void back() {

		driver.navigate().back();
	}

	protected void clickOnElement(By locator) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		} catch (ElementClickInterceptedException e) {
//			wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
			js.executeScript("arguments[0].click()", getElement(locator));
		} catch (StaleElementReferenceException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
