import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class OrderCreateAuthorizedTest extends OrderBaseTest {

    @Test
    @DisplayName("Заказ из всех ингридиентов с авторизацией")
    public void orderCreateAuyhorizedTest() {

        IngridientsResponse responseIngridients = orderClient.ingridientsGetResponse();

            List<Ingridient> ingridients = responseIngridients.getData();
            List<String> ingreidientsId = new ArrayList<String>();
              for (Ingridient i:ingridients  ){
               ingreidientsId.add(i.get_id());
                }

            UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, UserData.password, UserData.name);
            Response response = userClient.userRegisterResponse(userRegisterRequest);
            token = response.then().extract().path("accessToken");

            OrderCreateRequest orderCreateRequest = new OrderCreateRequest(ingreidientsId);
            Response responseOrder = orderClient.orderCreateAuthorizedResponse(orderCreateRequest, token);
            responseOrder.then().assertThat().statusCode(200).and().body("success", equalTo(true));

    }
}
