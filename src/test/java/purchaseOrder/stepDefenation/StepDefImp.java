package purchaseOrder.stepDefenation;

import java.io.IOException;

import org.testng.Assert;

import Base.compo.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.model.Cart;
import pageobject.model.DataForCheckOut;
import pageobject.model.LoginPage;
import pageobject.model.ProductAddToCart;

public class StepDefImp extends BaseTest {
	public LoginPage log;
	public ProductAddToCart btton;
	public DataForCheckOut chk1;
	public Cart krt;
	String productName = "Sauce Labs Bike Light";

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		log = launchApplication();

	}

	@Given("^I logged in with (.+) and (.+)$")
	public void logged_in_username_password(String name, String password) {
		btton = log.Login(name, password);

	}

	@When("I add  product to Cart")
	public void i_add_product_to_cart() {
	    krt = btton.AddToCard();
		krt.Cartproduct();
		krt.clickOnCartProuduct();
		String prod = krt.ProductName();
		krt.WindowsNavigate();
		Assert.assertEquals(productName, prod);
	}
	@Then("I checkhout for the product")
	public void I_checkhout_for_the_product() {
		DataForCheckOut chk1 = krt.CheckOut();
		chk1.CheckOut();
		chk1.FirstName();
		chk1.LastName();
		chk1.ZipCode();
		chk1.Continue();
		chk1.Finish();
		chk1.OrderConfirmation();
		driver.close();
		
	}
	

}
