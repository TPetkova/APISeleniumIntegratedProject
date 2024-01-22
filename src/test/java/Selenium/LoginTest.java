package Selenium;

import configuration.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview", "The page title is not as expected");
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8081/parabank/overview.htm", "The url is not as expected");
    }
}
