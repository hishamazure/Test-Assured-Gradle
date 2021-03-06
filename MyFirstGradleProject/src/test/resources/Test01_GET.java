import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test01_GET {
	
	@Test
	void test_01() {
		
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		//response.getBody();
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		System.out.println("--- HISHAM DONE ---");
	}
	
	@Test
	void test_02() {
		
	 
			given().
				get("https://reqres.in/api/users?page=2").
			then().
				statusCode(200).
				body("data.id[0]", equalTo(7));
		
	}
}
