import config.BaseURI;
import data.OrderData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import model.Order;
import model.OrderMethods;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.hasKey;

@RunWith(Parameterized.class)
public class OrderCreateTest {
    private OrderMethods orderMethods;
    private Order order;
    private int statusCode;
    private String OrderNumber;

    public OrderCreateTest(Order order, int statusCode) {
        this.order = order;
        this.statusCode = statusCode;
    }

    @Parameterized.Parameters
    public static Object[][] getTest() {
        return new Object[][]{
                {OrderData.scooterColourBlack(), 201},
                {OrderData.scooterColourGrey(), 201},
                {OrderData.scooterNoColour(),201},
                {OrderData.scooterAllColor(),201}
        };
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = BaseURI.baseURI;
        orderMethods = new OrderMethods();
    }

    @Test
    @DisplayName("Позитивный тест на создание заказа с самокатами разных цветов")
    public void createOrderOnScooter() {
        ValidatableResponse response = orderMethods.create(order)
                .statusCode(201)
                .body("$", hasKey("track"));
        System.out.println("Номер заказа: " + response.extract().body().path("track"));
    }
}
