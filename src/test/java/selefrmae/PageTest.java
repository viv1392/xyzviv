package selefrmae;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import Base.compo.BaseTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import pageobject.model.Cart;
import pageobject.model.DataForCheckOut;
import pageobject.model.ProductAddToCart;

public class PageTest extends BaseTest {
	@Test(dataProvider="datainit")
	public void order(HashMap<String,String> input) throws IOException {
		String productName = "Sauce Labs Bike Light";
		ProductAddToCart btton = log.Login(input.get("name"),input.get("password"));
		Cart krt = btton.AddToCard();
		krt.Cartproduct();
		krt.clickOnCartProuduct();
		String prod = krt.ProductName();
		krt.WindowsNavigate();
		Assert.assertEquals(productName, prod);
		DataForCheckOut chk1 = krt.CheckOut();
		chk1.CheckOut();
		chk1.FirstName();
		chk1.LastName();
		chk1.ZipCode();
		chk1.Continue();
		chk1.Finish();
		chk1.OrderConfirmation();
		
	}
	@DataProvider
	public Object[][] datainit() throws IOException {
	List<HashMap<String,String>> data=getData(System.getProperty("user.dir") + "\\src\\test\\java\\purchase\\data\\purchaseData.json");
			
	return new Object[][] {{data.get(0)}};
	}
}
