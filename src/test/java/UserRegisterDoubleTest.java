import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserRegisterDoubleTest extends UserBaseTest {
    @Test
    @DisplayName("Создание существующего пользователя")
    public void registerUserTest() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, UserData.password, UserData.name);
        Response response = userClient.userRegisterResponse(userRegisterRequest);
        token = response.then().extract().path("accessToken");

        Response response2 = userClient.userRegisterResponse(userRegisterRequest);
        response2.then().assertThat().statusCode(403).and().body("success", equalTo(false));


    }
}
