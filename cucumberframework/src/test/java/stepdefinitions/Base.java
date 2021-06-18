package stepdefinitions;

import org.openqa.selenium.WebDriver;

import apex.cucumberframework.mainPage;

//This class allows to use driver and all pages variables in other classes just extending this class
public class Base {
	
	static WebDriver driver;
	static mainPage mainPage;
	//other pages declaration here
}
