import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

//import java.util.HashMap;
//import java.util.Map;

public class Test_POST {

    //@Test
    public void test1_post(){

        //Map ile yönetim
        //Map<String, Object> map = new HashMap<String, Object>();

        //map.put("name", "Hande");
        //map.put("job", "engineer");

        //System.out.println(map);

        //Json ile yönetim
        JSONObject request = new JSONObject();

        request.put("name", "Hande");
        request.put("job", "engineer");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201);
    }

    //@Test
    public void test1_put(){

        JSONObject request = new JSONObject();

        request.put("name", "Hande");
        request.put("job", "engineer");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void test1_delete(){

        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204).
                log().all();
    }

}
