package platform.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ApiTest {
    private String json = "{\n" +
            "    \"prefix\": \"PT\",\n" +
            "    \"name\": \"Sejahtera\",\n" +
            "    \"suffix\": \"Tbk\",\n" +
            "    \"industry_id\": \"1\",\n" +
            "    \"employee_size\": \"500\",\n" +
            "    \"street\": \"Jl.Sudirman kav. 21\",\n" +
            "    \"place\": \"Sudirman Tower\",\n" +
            "    \"geograph_id\": 100,\n" +
            "    \"phone\": \"08561290092\",\n" +
            "}";

    @Test()
    public void ApiTest_01(){
        Response response = RestAssured.given().baseUri("https://run.mocky.io").body(json).expect().statusCode(200).when().get("/v3/855a69a2-b04e-45d8-bd67-f37f0af841bf");
        log.info(response.prettyPrint());
    }
}
