package model;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierMethods {
    public static final String CREATE_PATH = "/api/v1/courier";
    public static final String LOGIN_PATH = "/api/v1/courier/login";
    public static final String DELETE_PATH = "/api/v1/courier/";

    private int courierId;

@Step("Создание курьера")
    public ValidatableResponse create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(CREATE_PATH)
                .then();
    }
@Step("Логин курьера в системе")
    public ValidatableResponse login(CourierCredential credential) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(credential)
                .when()
                .post(LOGIN_PATH)
                .then();
    }
@Step("Получение")
    public int getId (CourierCredential credential){
        return login(credential)
                .extract()
                .path("id");
    }
@Step("Удаление курьера")
    public void delete(int courierId) {
        given()
                .header("Content-type", "application/json")
                .when()
                .delete(DELETE_PATH + courierId)
                .then().log().all();
    }
}
