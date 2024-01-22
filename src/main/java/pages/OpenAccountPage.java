package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.lang.constant.Constable;

public class OpenAccountPage extends BasePage{

    @FindBy(xpath = "//select[@id='type']/option[@value='0']") private WebElement accountTypeChecking;

    @FindBy(xpath = "//select[@id='type']/option[@value='1']") private WebElement accountTypeSavings;

    @FindBy(id = "type") private WebElement accountType;

    @FindBy(xpath = "//div/input[@type='submit']") private WebElement openAccountButton;

    @FindBy(xpath = "//div[@class='ng-scope']/h1[@class='title']") private WebElement verifyAccountText;

    @FindBy(xpath = "//a[@id='newAccountId']") private WebElement accountId;

    @FindBy(xpath = "//div[@class='ng-scope']/p[contains(text(),'Congratulations')]") private WebElement accountCreatedText;

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public void selectAccountType(String accountTypeValue) {
        Select accountTypeSelect = new Select(accountType);
        accountTypeSelect.selectByValue(accountTypeValue);
    }

    public void openAccount() {
        openAccountButton.click();
    }

    public String verifyAccountCreatedText() {
        return verifyAccountText.getText();
    }

    public WebElement waitAccountCreatedText() {
        return verifyAccountText;
    }

    public String checkAccountIdCreated() {
        return accountId.getText();
    }

    public String congratsText() {
        return accountCreatedText.getText();
    }

    public void clickAccountId() {
        accountId.click();
    }


}
