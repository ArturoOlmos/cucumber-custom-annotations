package apex.cucumberframework.customlocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ByShadowPath extends By 
{
	private final String[] shadowObjectPath;
    private final String lastObjectAttribute;
    private final String lastObjectAttributeValue;
    
    public ByShadowPath(String[] shadowPath,String HtmlAttribute, String attrValue)
    {
    	this.shadowObjectPath=shadowPath;
        this.lastObjectAttribute = HtmlAttribute;
        this.lastObjectAttributeValue = attrValue;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) 
    {
    	WebElement shadowElement=null;
    	for (int i = 0; i < shadowObjectPath.length ; i++) {
    		if (i>0) {
    			shadowElement=shadowElement.findElement(By.tagName(shadowObjectPath[i]));
    		}
    		else {
    			shadowElement=context.findElement(By.tagName(shadowObjectPath[i]));
    		}
    		WebElement ele = (WebElement) ((JavascriptExecutor) context).executeScript("return arguments[0].shadowRoot",shadowElement);
    		shadowElement=ele;
        }
         List<WebElement> mockElements = shadowElement.findElements(By.cssSelector("*["+lastObjectAttribute+"='" + lastObjectAttributeValue + "']"));
         return mockElements;
    }
}