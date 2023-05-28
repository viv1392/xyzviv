package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "purchaseOrder.stepDefenation", monochrome = true, plugin = {
		"html:target/cucumber.html" }, tags="@smoke")
public class TestNGTestRunner extends AbstractTestNGCucumberTests  {

}
