import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class Tests_POST {

	@Test
	public void test_1_post() {
		
		Map<String, Object> map = new HashMap<String , Object>();
		map.put("name", "Hisham");
		map.put("job", "Teacher");
		
		JSONObject  request = new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		request.put("job2", "Teacher2");
		System.out.println(request.toJSONString());
		
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201); // for post, success is 201
		
	}
}
