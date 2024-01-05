package pages;

import configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='login']/input[@name='username']") private WebElement loginUsername;
    @FindBy(xpath = "//div[@class='login']/input[@name='password']") private WebElement loginPassword;
    @FindBy(xpath = "//div[@class='login']/input[@value='Log In']") private WebElement loginButton;

    public void setloginUsername(String loginUsername) {
        this.loginUsername.sendKeys(loginUsername);
    }

    public void setloginPassword(String loginPassword) {
        this.loginPassword.sendKeys(loginPassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login() {
        setloginPassword(Configuration.getProperty("username"));
        setloginPassword(Configuration.getProperty("password"));
        clickLoginButton();
    }
}


