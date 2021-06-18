package apex.cucumberframework;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import apex.cucumberframework.generics;
import apex.cucumberframework.customlocators.ByHtmlAttribute;
import apex.cucumberframework.customlocators.ByShadowPath;
import apex.cucumberframework.customlocators.CustomFieldDecorator;
import apex.cucumberframework.customlocators.FindByCustom;
import apex.cucumberframework.customlocators.FindByShadowPath;
//REST ASSURED IMPORTS
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;


public class mainPage {
	WebDriver webdriver;
	WebElement genericElement;
	//mainPage mainPage;
	
	public mainPage(WebDriver driver) {
		 PageFactory.initElements(new CustomFieldDecorator(new DefaultElementLocatorFactory(driver)), this);
	     //PageFactory.initElements(driver, this);
	     wait = new WebDriverWait(driver,30);
	     webdriver=driver;
	 }
	
	WebDriverWait wait;
	
	@FindBy(how = How.TAG_NAME, using = "extensions-manager") 
	 private WebElement mainShadow;
	
	@FindBy(how = How.TAG_NAME, using = "extensions-toolbar") 
	 private WebElement secondShadow;
	
	@FindBy(how = How.ID, using = "devMode") 
	 private WebElement thirdShadow;
	
	@FindBy(how = How.ID, using = "knob") 
	 private WebElement devButton;
	
	@FindByCustom(HTMLAttribute = "title", HTMLValue = "Buscar")
		private WebElement fourthShadow;
	
	@FindByShadowPath(ShadowPath= {"extensions-manager","extensions-toolbar","cr-toggle"},HTMLAttribute = "id", HTMLValue = "knob")
		private WebElement devModeButton;
	
	
	
		
	
	public void enableDevTools() {
		//wait.until(ExpectedConditions.visibilityOf(learnTab));
		genericElement=generics.expandRootElement(mainShadow, webdriver);
		genericElement=genericElement.findElement(By.tagName("extensions-toolbar"));
		genericElement=generics.expandRootElement(genericElement, webdriver);
		//genericElement=genericElement.findElement(By.id("devMode"));
		genericElement=genericElement.findElement(new ByHtmlAttribute("id","devMode"));//ByHtmlAttribute search
		genericElement=generics.expandRootElement(genericElement, webdriver);
		genericElement=genericElement.findElement(By.id("knob"));
		genericElement.click();
		//genericElement=generics.expandRootElement(secondShadow, webdriver);
		//genericElement=generics.expandRootElement(thirdShadow, webdriver);
		//devButton.click();
		
	}
	
	public void enableButton() {
		String[] path= {"extensions-manager","extensions-toolbar","cr-toggle"};
		genericElement=generics.expandRootElement2(path,"id","knob",webdriver);
		genericElement.click();
		
	}
	
	public void enableButtonWithCustomClass() {
		String[] path= {"extensions-manager","extensions-toolbar","cr-toggle"};
		genericElement=webdriver.findElement(new ByShadowPath(path,"id","knob"));
		genericElement.click();
	}
	
	public void enableButtonWithAnnotation() {
		devModeButton.click();//custom annotation that handles shadowroot
		
	}
	
	
	
	public void first() {
		fourthShadow.sendKeys("Hola");
	}
	
	public void testGET() {
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response Body is =>  " + responseBody);
	}
	
	public void testPOST() {
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Virender"); 
		requestParams.put("job", "Singh");
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		 
		// Add the Json to the body of the request
		httpRequest.body(requestParams.toString());
		 
		// Post the request and check the response
		Response response = httpRequest.post("/api/users");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}
	

}
