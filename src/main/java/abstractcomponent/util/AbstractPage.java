package abstractcomponent.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	WebDriver driver;

	public AbstractPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void ActionClass() {
		Actions a = new Actions(driver);
		a.scrollByAmount(0, 700).build().perform();
	}

	public void WindowsNavigate() {
		driver.navigate().back();
	}
}
