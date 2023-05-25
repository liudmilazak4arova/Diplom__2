import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class OrderCreateWithoutIngridientsTest extends  OrderBaseTest {
    @Test
    @DisplayName("Заказ из без ингридиентов")
    public void orderCreateTest() {

        List<String> ingreidients = new ArrayList<String>();

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest(ingreidients);
        Response responseOrder = orderClient.orderCreateResponse(orderCreateRequest);

        responseOrder.then().assertThat().statusCode(400).and().body("success", equalTo(false));

    }
}
