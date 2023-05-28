package pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.util.AbstractPage;

public class DataForCheckOut extends AbstractPage {
	WebDriver driver;
	public DataForCheckOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="checkout")
	WebElement clickoncheckout;
	@FindBy(css="input[placeholder='First Name']")
	WebElement firstname;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	@FindBy(id="postal-code")
	WebElement zipcode;
	@FindBy(id="continue")
	WebElement contin;
	@FindBy(id="finish")
	WebElement finsh;
	@FindBy(xpath="//div/h2")
	WebElement orderconfirmation;
	
	public void CheckOut() {
		clickoncheckout.click();
		
	}
	public void FirstName() {
		firstname.sendKeys("vivek");
		
	}
	public void LastName() {
		lastname.sendKeys("pandey");
		
	}
	public void ZipCode() {
		zipcode.sendKeys("110030");
		
	}
	public void Continue() {
		contin.click();
	}
	public void Finish() {
		finsh.click();
	}
	public void OrderConfirmation() {
		String confirmation=orderconfirmation.getText();
		System.out.println(confirmation);
		
	}

}
