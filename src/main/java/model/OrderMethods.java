package model;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
public class OrderMethods {
    public static final String PATH = "/api/v1/orders";
@Step("Создание заказа")
    public ValidatableResponse create(Order order){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(PATH)
                .then();
    }
    @Step("Получение списка заказов")
    public ValidatableResponse returnOrderList(){
        return given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .get(PATH)
                .then();
    }
}
