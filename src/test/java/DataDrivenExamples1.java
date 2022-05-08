import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import javax.xml.crypto.Data;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples1 extends DataForTest{


    @Test(dataProvider = "DataForPost")
    public void test1_post(String firstName, String lastName, int subjectId){

        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }


    //@Test(dataProvider = "DeleteData")
    public void test_delete(int userId){

        baseURI = "http://localhost:3000/";

        when().
                delete("/users/" + userId).
        then().
                statusCode(200);
    }

    //Testng Parameters Kullanımı

    @Parameters({"userId"})
    @Test
    public void test_delete2(int userId){

        System.out.println("Value for userId:" + userId);

        baseURI = "http://localhost:3000/";

        when().
                delete("/users/" + userId).
                then().
                statusCode(200);
    }

}