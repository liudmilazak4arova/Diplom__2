import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserLoginWrongPassword extends UserBaseTest {

    @Test
    @DisplayName("Логин пользователя c неверными данными")
    public void loginUserTest() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, UserData.password, UserData.name);
        Response response = userClient.userRegisterResponse(userRegisterRequest);
        // response.then().assertThat().statusCode(200).and().body("success", equalTo(true));
        token = response.then().extract().path("accessToken");

        UserLoginRequest userLoginRequest = new UserLoginRequest("login", null);
        Response responseLogin = userClient.userLoginResponse(userLoginRequest);
        responseLogin.then().assertThat().statusCode(401).and().body("success", equalTo(false));
    }
}
