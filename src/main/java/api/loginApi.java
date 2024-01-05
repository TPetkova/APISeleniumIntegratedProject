package api;

import configuration.Configuration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.requestSpecification;

public class loginApi {
    public static Response login(String username, String password) {
        RestAssured.baseURI = Configuration.getProperty("baseUrl");
        RestAssured.basePath = Configuration.getProperty("loginEndpoint");

        requestSpecification = new RequestSpecBuilder()
                .setBody(String.format("{\"username\": \"%s\", \"password\": \"%s\"}",username,password))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
        return post();

    }
}
