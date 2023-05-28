package pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.util.AbstractPage;

public class LoginPage extends AbstractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement username;
	@FindBy(id = "password")
	WebElement pass;
	@FindBy(id = "login-button")
	WebElement loginbutton;
	@FindBy(xpath = "//div/h3")
	WebElement errormsg;

	public ProductAddToCart Login(String name, String password) {
		username.sendKeys(name);
		pass.sendKeys(password);
		loginbutton.click();
		ProductAddToCart cartbutton = new ProductAddToCart(driver);
		return cartbutton;
	}

	public String ErrorMessage() {
		String errmsg = errormsg.getText();
		return errmsg;

	}

	

}
