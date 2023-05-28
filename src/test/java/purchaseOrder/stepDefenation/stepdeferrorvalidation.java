package purchaseOrder.stepDefenation;

import java.io.IOException;

import org.testng.Assert;

import Base.compo.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.model.LoginPage;
import pageobject.model.ProductAddToCart;
public class stepdeferrorvalidation extends BaseTest {
	LoginPage log;
	ProductAddToCart btton;

	@Given("I landed on the Ecommerce website")
	public void i_landed_on_ecommerce_website() throws IOException {
		 log=launchApplication(); 
	}

	@Then("^I logg in with (.+) and (.+)$")
	public void i_logged_in(String name, String password) {
		log.Login(name, password);
		driver.close();
	}
	

	
}
