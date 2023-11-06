package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {

		super(driver);
	}

	private By firstProduct = By.cssSelector(".container .card:nth-child(1)");
	private By secondProduct = By.cssSelector(".container .card:nth-child(2)");
	private By addToCartButton = By.id("btn-add-to-cart");
	private By cartItem = By.cssSelector("[data-test='nav-cart']");
	private By cartQuantity = By.cssSelector("[data-test='cart-quantity']");
	private By productsInCart = By.xpath("//table[@class='table table-hover'] //tbody //tr");
	private By quantityOfProducts = By.cssSelector(".form-control.quantity");
	private By firstQuantity = By.xpath("//table[@class='table table-hover']//tbody//tr[1]/td[3]");
	private By pricesOfProducts = By.xpath("//tbody//tr//td[5]//span");
	private By totalPrice = By.xpath("//tfoot//tr//td[5]");

	public void addProductsInCart() throws InterruptedException {

		clickOnElement(firstProduct);
		clickOnElement(addToCartButton);
		back();
		clickOnElement(secondProduct);
		clickOnElement(addToCartButton);
		Thread.sleep(1000);
		clickOnElement(cartItem);
	}

	public Boolean assertNumberOfProductsInCart() {

		int sumOfQuantity = 0;

		List<WebElement> productListQuantity = getListOfWebElements(quantityOfProducts);

		for (WebElement quantity : productListQuantity) {

			String getAttributeValueExpected = quantity.getAttribute("value");
			sumOfQuantity += parseInt(getAttributeValueExpected);
		}

		return parseInt(getElement(cartQuantity).getText()) == sumOfQuantity;
	}

	public Boolean assertPricesTotalSum() {

		double sum = 0;

		List<WebElement> listOfPrices = getListOfWebElements(pricesOfProducts);

		for (WebElement prices : listOfPrices) {

			String pricesOfProducts = prices.getText().replace("$", "");
			sum += parseDouble(pricesOfProducts);
		}

		return parseDouble(getElement(totalPrice).getText().replace("$", "")) == sum;
	}
}
