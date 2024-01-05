package API;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import api.loginApi;

import static io.restassured.RestAssured.post;

public class LoginTest {
    @Test
    public void login(String username, String password) {
        Response response = loginApi.login(username,password);
        response.then().assertThat().statusCode(200);
    }

}
