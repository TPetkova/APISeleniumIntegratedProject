package Selenium;

import data.LeftPanelEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    private HomePage homePage;
    private OpenAccountPage openAccountPage;
    private WebDriverWait wait;
    private AccountActivityPage accountActivityPage;
    private TransferFundsPage transferFundsPage;

    @BeforeTest
    public void init() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        this.homePage = homePage;
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        this.openAccountPage = openAccountPage;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.wait = wait;
        AccountActivityPage accountActivityPage = new AccountActivityPage(driver);
        this.accountActivityPage = accountActivityPage;
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        this.transferFundsPage = transferFundsPage;
    }

    @DataProvider (name = "accountType")
    public Object[][] dpMethod(){
        return new Object[][] {{"0"}, {"1"}};
    }

    @Test (dataProvider = "accountType")
    //@Parameters({"accountType"})
    public void openNewAccount(String accountType) {
        homePage.leftPanelElement(LeftPanelEnum.OPEN_NEW_ACCOUNT.toString()).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8081/parabank/openaccount.htm"), "URL is not as expected");
        openAccountPage.selectAccountType(accountType);
        openAccountPage.openAccount();
        //wait.until(ExpectedConditions.visibilityOf(openAccountPage.waitAccountCreatedText()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-scope']/h1[@class='title']")));
        Assert.assertTrue(openAccountPage.verifyAccountCreatedText().equalsIgnoreCase("Account Opened!"), "Error when creating account");
        Assert.assertTrue(openAccountPage.congratsText().equalsIgnoreCase("Congratulations, your account is now open."), "Congrats message is not as expected");
        //Assert.assertTrue(openAccountPage.checkAccountIdCreated().contains("Your new account number:"));
        Assert.assertEquals(openAccountPage.checkAccountIdCreated().length(),5, "Account id is not with 5 characters");
        String newAccountId = openAccountPage.checkAccountIdCreated();
        openAccountPage.clickAccountId();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8081/parabank/activity.htm?id=" + newAccountId));
        Assert.assertEquals(accountActivityPage.getAccountNumberId(),newAccountId, "Accounts are different");
        switch (accountType) {
            case "0":
                Assert.assertTrue(accountActivityPage.getAccountType().equalsIgnoreCase("CHECKING"), "Account type is NOT Checking" );
                break;
            case "1":
                Assert.assertTrue(accountActivityPage.getAccountType().equalsIgnoreCase("SAVINGS"), "Account type is NOT Savings" );
                break;
            default:
                System.out.println("Invalid account type");
        }
    }

    @Test
    public void accountOverview() {
        homePage.leftPanelElement(LeftPanelEnum.ACCOUNTS_OVERVIEW.toString()).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8081/parabank/overview.htm"));
    }

    @Test
    public void transferFunds() {
        homePage.leftPanelElement(LeftPanelEnum.TRANSFER_FUNDS.toString()).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8081/parabank/transfer.htm"));
        transferFundsPage.setFundTransferAmount(3.33);
        transferFundsPage.selectFromAccount("1412100");
        transferFundsPage.selectToAccount("14010");
        transferFundsPage.clickTransfer();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-scope']/h1[@class='title']")));
        Assert.assertEquals(transferFundsPage.getSuccessMessage(), "Transfer Complete!");
    }

    @Test
    public void billPay() {

    }
}
