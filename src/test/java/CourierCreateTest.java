import config.BaseURI;
import data.CourierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;

import model.Courier;
import model.CourierCredential;
import model.CourierMethods;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;



public class CourierCreateTest {
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
    @DisplayName("Позитивный тест на создание курьера")
    public void courierIsCreated() {
        courierMethods.create(courier)
                .statusCode(201)
                .and()
                .body("ok", equalTo(true));
        id = courierMethods.getId(CourierCredential.from(courier));
        courierMethods.delete(id);
    }
    @Test
    @DisplayName("Ошибка при создании двух курьеров с одинаковым логопасом")
    public void duplicateCourier(){
        courierMethods.create(courier);
        courierMethods.create(courier)
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
        id = courierMethods.getId(CourierCredential.from(courier));
        courierMethods.delete(id);
    }

    @Test
    @DisplayName("Ошибка при создании курьеров с одинаковым логином")
    public void addCourierWithBookedLogin() {
        courierMethods.create(courier);

        Courier secondCourier = new Courier();
        secondCourier.setLogin("ninja");
        secondCourier.setPassword("парирумчик");
        secondCourier.setFirstName("saske");

        courierMethods.create(secondCourier)
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));

        int id = courierMethods.getId(CourierCredential.from(courier));
        courierMethods.delete(id);
    }







    @Test
    @DisplayName("Ошибка при создании курьера без логина")
    public void createCourierWithoutLogin(){
        courier = CourierData.courierWithoutLogin();
        courierMethods.create(courier)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));

    }

    @Test
    @DisplayName("Ошибка при создании курьера без пароля")
    public void createCourierWithoutPassword(){
        courier = CourierData.courierWirhoutPassword();
        courierMethods.create(courier)
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));

    }




}
