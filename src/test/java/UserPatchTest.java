import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserPatchTest extends UserBaseTest{
    @Test
    @DisplayName("Редактирование пользователя")
    public void loginUserTest() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest(UserData.email, UserData.password, UserData.name);
        Response response = userClient.userRegisterResponse(userRegisterRequest);
        response.then().assertThat().statusCode(200).and().body("success", equalTo(true));
        token = response.then().extract().path("accessToken");

        Random random = new Random();
        UserRegisterRequest userPatchRequest = new UserRegisterRequest("e" + random.toString(), "password","name");
        Response responsePatch = userClient.userPatchResponse(userPatchRequest, token );

        responsePatch.then().assertThat().statusCode(200).and().body("success", equalTo(true));

    }
}
