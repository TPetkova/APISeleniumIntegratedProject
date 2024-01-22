package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends BasePage{
    @FindBy(id = "amount") private WebElement fundTransferAmount;

    @FindBy(id = "fromAccountId") private WebElement fromAccountId;

    @FindBy(id = "toAccountId") private WebElement toAccountId;

    @FindBy(xpath = "//input[@type='submit'][@class='button']") private WebElement transferButton;

    @FindBy(xpath = "//div[@class='ng-scope']/h1[@class='title']") private WebElement successMessage;

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public void setFundTransferAmount(double amount) {
        fundTransferAmount.sendKeys(Double.toString(amount));
    }

    public void selectFromAccount(String fromAccount) {
        Select accountFromSelect = new Select(fromAccountId);
        accountFromSelect.selectByValue(fromAccount);
    }

    public void selectToAccount(String toAccount) {
        Select accountToSelect = new Select(toAccountId);
        accountToSelect.selectByValue(toAccount);
    }

    public void clickTransfer() {
        transferButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
