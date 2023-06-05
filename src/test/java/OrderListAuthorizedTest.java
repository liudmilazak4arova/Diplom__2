import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderListAuthorizedTest extends OrderBaseTest{
    @Test
    @DisplayName("Список заказов авторизoванного клиента")
    public void orderCreateTest() {
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
        orderClient.orderCreateAuthorizedResponse(orderCreateRequest, token);

        Response responseOrderList = orderClient.orderListAuthorizedResponse(token);
        responseOrderList.then().assertThat().statusCode(200);

    }
}
