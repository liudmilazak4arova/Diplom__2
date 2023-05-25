import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

public class UserBaseTest {

    protected UserClient userClient;
    protected String token;

    @Before
    public void setUp() {
        RestAssured.baseURI = GlobalData.URL;
        userClient = new UserClient();
    }

    @After
    public void revert(){
       if ((token!=null)){
      Response responseDelete= userClient.userDeleteResponse(token);}
   }
}
