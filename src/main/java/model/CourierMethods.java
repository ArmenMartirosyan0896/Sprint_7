package model;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierMethods {
    private static String CREATE_PATH = "/api/v1/courier";
    private static String LOGIN_PATH = "/api/v1/courier/login";
    private static String DELETE_PATH = "/api/v1/courier/";

    private int courierId;

    public ValidatableResponse create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(CREATE_PATH)
                .then();
    }

    public ValidatableResponse login(CourierCredential credential) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(credential)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    public int getId (CourierCredential credential){
        return login(credential)
                .extract()
                .path("id");
    }

    public void delete(int courierId) {
        given()
                .header("Content-type", "application/json")
                .when()
                .delete(DELETE_PATH + courierId)
                .then().log().all();
    }
}
