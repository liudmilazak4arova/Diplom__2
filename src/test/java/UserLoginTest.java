import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserLoginTest extends UserBaseTest {

    @Test
    @DisplayName("Логин пользователя")
    public void loginUserTest() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, UserData.password, UserData.name);
        Response response = userClient.userRegisterResponse(userRegisterRequest);
        //response.then().assertThat().statusCode(200).and().body("success", equalTo(true));
        token = response.then().extract().path("accessToken");
        System.out.println(token);
        UserLoginRequest userLoginRequest = new UserLoginRequest(UserData.email, UserData.password);
        Response responseLogin = userClient.userLoginResponse(userLoginRequest);
        responseLogin.then().assertThat().statusCode(200).and().body("success", equalTo(true));
    }
}
