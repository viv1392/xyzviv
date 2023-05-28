package Base.compo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.model.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage log;

	public WebDriver initiliseDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\global\\compo\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			// WebDriverManager.edgedriver().setup();
			// EdgeDriver driver=new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// code here
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	public List<HashMap<String, String>> getData(String filepath) throws IOException {
		String jasonfile = FileUtils.readFileToString(
				new File(filepath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jasonfile,
				new TypeReference<List<HashMap<String, String>>>() {

				});
		return data;

	}
	public String screenShot(String testCaseName ,WebDriver driver) throws IOException {
		TakesScreenshot ts	=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+ testCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
		} 


	@BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver = initiliseDriver();
		log = new LoginPage(driver);
		driver.get("https://www.saucedemo.com/");
		return log;
	}

	@AfterMethod
	public void CloseDriver() {
		driver.close();

	}


}
