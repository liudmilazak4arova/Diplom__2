import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserClient {

    @Step("Get response for create user requests")
    public Response userRegisterResponse(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(GlobalData.SERVICE_USER_REGISTER);
    }

    @Step("Get response for delete user requests")
    public Response userDeleteResponse(String token) {
        return given()
                .header("Authorization", token)
                .when()
                .delete(GlobalData.SERVICE_USER_DELETE);
    }

    @Step("Get response for login user requests|")
    public Response userLoginResponse(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(GlobalData.SERVICE_USER_LOGIN);
    }
    @Step("Get response for patch user requests|")
    public Response userPatchResponse(Object body, String token) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .body(body)
                .when()
                .patch(GlobalData.SERVICE_USER_PATCH);
    }
}