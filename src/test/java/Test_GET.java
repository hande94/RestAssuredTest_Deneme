import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test_GET {

    @Test
    void test1(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response : " + response.asString());
        System.out.println("Body : " + response.getBody().asString());
        System.out.println("Time taken : " + response.getTime());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        //after import RestAssured staticly

    }

    @Test
    void test2(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[1]",equalTo(8)).
                body("data.last_name",hasItems("Edwards", "Funke"));
    }

}
