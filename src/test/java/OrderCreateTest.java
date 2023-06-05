import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class OrderCreateTest extends OrderBaseTest {
    @Test
    @DisplayName("Заказ из двух случайных ингридиентов")
    public void orderCreateTest() {

        IngridientsResponse responseIngridients = orderClient.ingridientsGetResponse();
        Random random = new Random();
        List<Ingridient> ingridientList = responseIngridients.getData();
        Ingridient ingridient1 = ingridientList.get(random.nextInt(ingridientList.size()-1));
        Ingridient ingridient2 = ingridientList.get(random.nextInt(ingridientList.size()-1));

        List<String> ingreidients = new ArrayList<String>();
        ingreidients.add(ingridient1.get_id());
        ingreidients.add(ingridient2.get_id());
        OrderCreateRequest orderCreateRequest = new OrderCreateRequest(ingreidients);
        Response responseOrder = orderClient.orderCreateResponse(orderCreateRequest);

        responseOrder.then().assertThat().statusCode(200).and().body("success", equalTo(true));

    }
}
