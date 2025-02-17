package test.testCaseFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testCreateUser() {

        RestAssured.baseURI = "https://reqres.in";

        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")  
                .then()
                .contentType(ContentType.JSON) 
                .statusCode(201) // Verify successful creation status cod
                .body("name", equalTo("morpheus")) // Verify name in the response
                .body("job", equalTo("leader")) // Verify job in the response
                .extract().response();

        // Optional: Print the response for debugging
        System.out.println(response.prettyPrint());

        // Additional assertions (if needed):
        String id = response.jsonPath().getString("id");
        Assert.assertNotNull(id, "ID should not be null"); 
    }
}