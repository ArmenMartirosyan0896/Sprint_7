import config.BaseURI;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import model.OrderMethods;
import org.junit.Before;
import org.junit.Test;

public class OrderListTest {
    private OrderMethods orderMethods;

    @Before
    public void setUp() {
        RestAssured.baseURI = BaseURI.baseURI;
        orderMethods = new OrderMethods();
    }

    @Test
    @DisplayName("Позитивный тест на получение списка заказов")
    public void getListOfOrders(){
        orderMethods.returnOrderList()
                .statusCode(200)
                .extract()
                .path("orders");
    }
}
