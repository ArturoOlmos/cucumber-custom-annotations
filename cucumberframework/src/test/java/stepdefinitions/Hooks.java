package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import apex.cucumberframework.mainPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hooks extends Base{
	
	public static Scenario message;//This helper allow us to screenshot after each step
	
	//method to screenshot (called after each step @AfterStep)
	public static void takeScreenShot() {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        message.embed(screenshot, "image/png");
    }
	
	 @Before
	 public void initializePagesAndBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Arturo Olmos\\eclipse-workspace\\cucumberframework\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://www.google.com/");
		driver.get("chrome://extensions/");
		mainPage = new mainPage(driver);
	 }
	 
	 //We set the helper variable for screenshots
	 @Before
	 public void setUpScenario(Scenario scenario) {
		 message=scenario;
	 }
	
	
	 @After
	 public void AfterScenario(Scenario scenario) {
		 //driver.close();
		 System.out.println(scenario.getName() + " was executed with status " + scenario.getStatus());
	 }
	 
	 @AfterStep
	 public void AfterStep() {
		 takeScreenShot();
		 System.out.println("After step was executed properly");
	 }

}
