import config.BaseURI;
import data.CourierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import model.Courier;
import model.CourierCredential;
import model.CourierMethods;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class CourierLoginTest {
    private Courier courier;
    private CourierMethods courierMethods;
    private int id;

    @Before
    public void setUp() {
        RestAssured.baseURI = BaseURI.baseURI;
        courier = CourierData.defaultCourier();
        courierMethods = new CourierMethods();
    }


    @Test
    @DisplayName("Позитивный тест на авторизацию")
    public void CourierLogin(){
        courierMethods.create(courier);
        courierMethods.login(CourierCredential.from(courier))
                .statusCode(200)
                .extract().path("id");
        ValidatableResponse responseLogin = courierMethods.login(CourierCredential.from(courier));
        id = responseLogin.extract().path("id");
    }
    @Test
    @DisplayName("Ошибка при авторизации с неверным паролем")
    public void loginWithWrongPassword(){
        courierMethods.create(courier);
        courier.setPassword("парирумчик");
        courierMethods.login(CourierCredential.from(courier))
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Ошибка при авторизации без логина")
    public void loginWithoutLogin(){
        courier = CourierData.courierWithoutLogin();
        courierMethods.create(courier);
        courierMethods.login(CourierCredential.from(courier))
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Ошибка при авторизации без пароля")
    public void loginWithoutPassword(){
        courier = CourierData.courierWirhoutPassword();
        courierMethods.create(courier);
        courierMethods.login(CourierCredential.from(courier))
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }


}
