package pages;

import configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='loginPanel']//p[2]//a") private WebElement registerButton;
    @FindBy(id = "customer.firstName") private WebElement firstName;
    @FindBy(id = "customer.lastName") private WebElement lastName;
    @FindBy(id = "customer.username") private WebElement username;
    @FindBy(id = "customer.password") private WebElement password;
    @FindBy(id = "repeatedPassword") private WebElement repeatedPassword;
    @FindBy(xpath = "//input[@class='button'][@value='Register']") private WebElement submitButton;
    @FindBy(xpath = "//div[@id='rightPanel']/h1[@class='title']") private WebElement title;
    @FindBy(xpath = "//div[@id='rightPanel']/p") private WebElement successMessage;
    @FindBy(id = "customer.address.street") private WebElement address;
    @FindBy(id = "customer.address.city") private WebElement city;
    @FindBy(id = "customer.address.state") private WebElement state;
    @FindBy(id = "customer.address.zipCode") private WebElement zipCode;
    @FindBy(id = "customer.phoneNumber") private WebElement phoneNumber;
    @FindBy(id = "customer.ssn") private WebElement ssn;


    public void clickRegister(){
        registerButton.click();
    }

    public void setFirstName(String firstName) {
       this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setUsername(String username) {
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword.sendKeys(repeatedPassword);
    }

    public void clickSubmitRegister() {
        submitButton.click();
    }

    public String verifyTitle() {
        return title.getText();
    }

    public String verifyMessage() {
        return successMessage.getText();
    }

    public void setAddress(String address) {
        this.address.sendKeys(address);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setState(String state) {
        this.state.sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        this.zipCode.sendKeys(String.valueOf(zipCode));
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(String.valueOf(phoneNumber));
    }

    public void setSSN(String ssn) {
        this.ssn.sendKeys(String.valueOf(ssn));
    }

    public void register() {
        clickRegister();
        clickRegister();
        setFirstName(Configuration.getProperty("firstName"));
        setLastName(Configuration.getProperty("lastName"));
        setAddress(Configuration.getProperty("address"));
        setCity(Configuration.getProperty("city"));
        setState(Configuration.getProperty("state"));
        setZipCode(Configuration.getProperty("zipCode"));
        setPhoneNumber(Configuration.getProperty("phoneNumber"));
        setSSN(Configuration.getProperty("ssn"));
        setUsername(Configuration.getProperty("username"));
        setPassword(Configuration.getProperty("password"));
        setRepeatedPassword(Configuration.getProperty("password"));
        clickSubmitRegister();
    }

}
