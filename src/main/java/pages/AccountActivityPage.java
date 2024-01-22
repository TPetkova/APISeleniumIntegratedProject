package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityPage extends BasePage{
    @FindBy(id = "accountId") private WebElement accountIdNumber;
    @FindBy(id = "accountType") private WebElement accountType;
    public AccountActivityPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountNumberId() {
        return accountIdNumber.getText();
    }

    public String getAccountType() {
        return accountType.getText();
    }
}
