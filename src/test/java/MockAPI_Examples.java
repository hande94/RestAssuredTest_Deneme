import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
//import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class MockAPI_Examples {

    //@Test
    public void test_get(){

        baseURI = "http://localhost:3000/";

        given().
                param("name", "Automation").
                get("/subjects").
        then().
                statusCode(200).
                log().all();
    }

    //@Test
    public void test_post(){

        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();

        request.put("firstName", "Tom");
        request.put("lastName", "Cooper");
        request.put("subjectId", "1");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();


    }

    //@Test
    public void test_patch(){

        baseURI = "http://localhost:3000/";

        JSONObject request = new JSONObject();

        request.put("lastName", "Cooper2");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                patch("/users/4").
        then().
                statusCode(200).
                log().all();

    }

    //@Test
    public void test_delete(){

        baseURI = "http://localhost:3000/";

        when().
                delete("/users/2").
        then().
                statusCode(200);
    }



}
