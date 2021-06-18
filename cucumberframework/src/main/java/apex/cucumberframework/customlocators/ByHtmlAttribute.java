package apex.cucumberframework.customlocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ByHtmlAttribute extends By 
{
    private final String htmlAttribute;
    private final String attributeValue;
    public ByHtmlAttribute(String HtmlAttribute, String attrValue)
    {
        this.htmlAttribute = HtmlAttribute;
        this.attributeValue = attrValue;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) 
    {
         List<WebElement> mockElements = context.findElements(By.cssSelector("*["+htmlAttribute+"='" + attributeValue + "']"));
         return mockElements;
    }
}