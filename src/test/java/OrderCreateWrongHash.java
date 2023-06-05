import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderCreateWrongHash extends  OrderBaseTest{
    @Test
    @DisplayName("Заказ из ингридиентов со случацным хешем")
    public void orderCreateTest() {
        List<String> ingreidients = new ArrayList<String>();
        ingreidients.add(String.valueOf(hashCode()));
        ingreidients.add(String.valueOf(hashCode()));
        OrderCreateRequest orderCreateRequest = new OrderCreateRequest(ingreidients);
        Response responseOrder = orderClient.orderCreateResponse(orderCreateRequest);
        responseOrder.then().assertThat().statusCode(500);

    }
}
