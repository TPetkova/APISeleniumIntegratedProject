package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li") private List<WebElement> leftPanelListElements;

    public WebElement leftPanelElement(String item) {
        for (WebElement element : leftPanelListElements) {
            String elementToString = element.getText();
            if (elementToString.equals(item)) {
                return element;
            }
        }
        return null;
    }
}
