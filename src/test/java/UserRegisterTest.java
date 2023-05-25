import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class UserRegisterTest extends UserBaseTest{

    @Test
    @DisplayName("Создание пользователя")
    public void registerUserTest() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, UserData.password, UserData.name);
        Response response = userClient.userRegisterResponse(userRegisterRequest);
        response.then().assertThat().statusCode(200).and().body("success", equalTo(true));
        token = response.then().extract().path("accessToken");
        System.out.println(token);
    }
}
