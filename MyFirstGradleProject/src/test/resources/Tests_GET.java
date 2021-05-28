import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Tests_GET {
	
	@Test
	public void test_1() {
		
		given().get("https://reqres.in/api/users?page=2").
			then().
				statusCode(200).
				body("data.id[1]", equalTo(8)).
				body("data.first_name[1]", equalTo("Lindsay")).
				log().all();
		
	}
	
	@Test
	public void test_2() {
		
		given().get("https://reqres.in/api/users?page=2").
			then().
				statusCode(200).
				body("data.id[1]", equalTo(8)).
				body("data.first_name", hasItems("Tobias", "Byron"));			
		
	}

}
