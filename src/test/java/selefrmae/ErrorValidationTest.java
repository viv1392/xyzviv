package selefrmae;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.compo.BaseTest;
import Base.compo.Retry;
import pageobject.model.Cart;
import pageobject.model.DataForCheckOut;
import pageobject.model.ProductAddToCart;


public class ErrorValidationTest extends BaseTest {
	@Test(retryAnalyzer=Retry.class)
	public void loginErr() throws IOException {
		log.Login("standard_user", "secret_sauccve");
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
				log.ErrorMessage());

	}
	@Test(dataProvider="datainit")
	public void producvalidation(HashMap<String,String> input) {
		String productName = "Sauce Labs Bike Light 44 ";
		ProductAddToCart btton = log.Login(input.get("name"),input.get("password"));
		Cart krt = btton.AddToCard();
		krt.Cartproduct();
		krt.clickOnCartProuduct();
		String prod = krt.ProductName();
		Assert.assertEquals(productName, prod);
		krt.WindowsNavigate();
		DataForCheckOut chk1 = krt.CheckOut();
		chk1.CheckOut();
		chk1.FirstName();
		chk1.LastName();
		chk1.ZipCode();
		chk1.Continue();
		chk1.Finish();
	}
	@DataProvider
	public Object[][] datainit() throws IOException {
	List<HashMap<String,String>> data=getData(System.getProperty("user.dir") + "\\src\\test\\java\\purchase\\data\\purchaseData.json");
			
	return new Object[][] {{data.get(0)}};
	}
}
