import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserCreateWithoutPasswordTest  extends UserBaseTest{
    @Test
    @DisplayName("Создание пользователя без пароля" )
    public void registerUserTest() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, null, UserData.name);
        Response response = userClient.userRegisterResponse(userRegisterRequest);
        response.then().assertThat().statusCode(403).and().body("success", equalTo(false));
        token = response.then().extract().path("accessToken");


    }
}
