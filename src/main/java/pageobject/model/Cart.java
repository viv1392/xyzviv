package pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.util.AbstractPage;

public class Cart extends AbstractPage {
	public WebDriver driver;
	public DataForCheckOut chk;
	
	public Cart (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartclick;
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	WebElement productlink;
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	WebElement productname;
	
	 public void Cartproduct() {
		 cartclick.click();
	 }
	 public void clickOnCartProuduct() {
		 productlink.click();
		 
	 }
	 public String ProductName() {
		String name= productname.getText();
		return name;
		
	 }
	 public DataForCheckOut CheckOut() {
		 chk=new DataForCheckOut(driver);
		 return chk;
		 
	 }

}


//driver.findElement(By.xpath("(//button[text()=' Add To Cart'])[2]")).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(
			//	ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()=' Product Added To Cart ']")));
		//driver.findElement(By.xpath("//label[text()='1']")).click();
