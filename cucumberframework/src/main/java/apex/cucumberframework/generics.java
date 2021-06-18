package apex.cucumberframework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class generics {
	
	public static WebElement expandRootElement(WebElement element, WebDriver driver) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}
	
	public static WebElement expandRootElement2(String[] shadowObjectPath,String attr, String attr_value ,WebDriver driver) {
	
		WebElement shadowElement=null;
    	for (int i = 0; i < shadowObjectPath.length ; i++) {
    		if (i>0) {
    			shadowElement=shadowElement.findElement(By.tagName(shadowObjectPath[i]));
    		}
    		else {
    			shadowElement=driver.findElement(By.tagName(shadowObjectPath[i]));
    		}
    		System.out.println(shadowElement.getTagName());
    		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",shadowElement);
    		shadowElement=ele;
        }
         WebElement mockElements = shadowElement.findElement(By.cssSelector("*["+attr+"='" + attr_value + "']"));
         return mockElements;
	}

}
