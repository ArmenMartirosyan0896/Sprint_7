package model;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
public class OrderMethods {
    private static String PATH = "/api/v1/orders";

    public ValidatableResponse create(Order order){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(PATH)
                .then();
    }
    public ValidatableResponse returnOrderList(){
        return given()
                .header("Content-type", "application/json")
                .and()
                .when()
                .get(PATH)
                .then();
    }
}
