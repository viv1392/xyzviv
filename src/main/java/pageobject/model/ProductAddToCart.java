package pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.util.AbstractPage;

public class ProductAddToCart extends AbstractPage {

	WebDriver driver;
	public Cart crt;

	public ProductAddToCart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement addtocart;

	public Cart AddToCard() {
		addtocart.click();
		crt = new Cart(driver);
		return crt;
	}

}
