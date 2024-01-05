package Selenium;

import configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v117.network.model.IPAddressSpace;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

 @Test
    public void register() {
     RegisterPage registerPage = new RegisterPage(driver);
  try {
   Thread.sleep(3000);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
     registerPage.register();
     Assert.assertEquals(registerPage.verifyTitle(),"Welcome" + Configuration.getProperty("username"),"Username is not as expected");
     Assert.assertEquals(registerPage.verifyMessage(),"Your account was created successfully. You are now logged in.","Success message is not as expected");
 }

}
