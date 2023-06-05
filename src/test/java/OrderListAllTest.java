import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
public class OrderListAllTest extends OrderBaseTest {

    @Test
    @DisplayName("Список заказов")
    public void  orderListAllTest() {
        Response responseOrder = orderClient.orderListAllResponse();
        responseOrder.then().assertThat().statusCode(200);

    }

}
