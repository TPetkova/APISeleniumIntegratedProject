package API;

import Selenium.BaseTest;
import configuration.Configuration;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import api.loginApi;

import static io.restassured.RestAssured.post;

public class LoginTest extends BaseTest {
    @Test
    public void login(String username, String password) {
        Response response = loginApi.login(Configuration.getProperty("username"),Configuration.getProperty("password"));
        response.then().assertThat().statusCode(200);
    }

}
