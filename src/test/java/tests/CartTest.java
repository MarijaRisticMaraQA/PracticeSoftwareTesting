package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

	CartPage cartPage;

	@BeforeMethod
	public void setUpCartPage() {

		cartPage = new CartPage(driver);
	}

	@Test
	public void cartTest() throws InterruptedException {

		cartPage.addProductsInCart();
		Thread.sleep(1000);
		assertTrue(cartPage.assertNumberOfProductsInCart());
		Thread.sleep(1000);
		assertTrue(cartPage.assertPricesTotalSum());
	}
}
