import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClient {


    @Step("Get response for ingridients")
    public IngridientsResponse  ingridientsGetResponse() {
        return given()
                .header("Content-type", "application/json")
                .get(GlobalData.SERVICE_INGRIDIENT)
                .body().as(IngridientsResponse.class);
    }

    @Step("Get response for create order")
    public Response orderCreateResponse(Object body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(GlobalData.SERVICE_ORDERS);
    }

    @Step("Get response for create authorized order")
    public Response orderCreateAuthorizedResponse(Object body, String token) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .body(body)
                .when()
                .post(GlobalData.SERVICE_ORDERS);
    }

    @Step("Get response for create authorized order")
    public Response orderListAllResponse() {
        return given()
                .header("Content-type", "application/json")
                .get(GlobalData.SERVICE_ORDERS_ALL);
    }

    @Step("Get response for create authorized order")
    public Response orderListAuthorizedResponse(String token) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .get(GlobalData.SERVICE_ORDERS);
    }
}
