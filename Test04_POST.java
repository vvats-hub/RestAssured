import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Test04_POST {
	
	@Test
	public void test_1_post() {
		Map<String,Object> map = new HashMap();
		map.put("name", "Raddison");
		map.put("job","Teacher");
		
		System.out.println("java variable :" + map);
		
		//converting map to json object to be passed to the api
		JSONObject request = new JSONObject(map);
		
		System.out.println("JSON variable: " + request);
	}
	
	@Test
	public void test_2_post() {
		
		JSONObject request = new JSONObject();
	    request.put("name", "Raddison");
		request.put("job","Teacher");
			
		System.out.println("JSON variable: " + request);
		System.out.println("JSON variable1: " + request.toJSONString());
		
		given().
		    body(request.toJSONString()).
		when().
		    post("https://reqres.in/api/users").
		then().
		   statusCode(201);
		    
	}
	
    @Test
    public void test_3_put() {
		
		JSONObject request = new JSONObject();
	    request.put("name", "Raddison");
		request.put("job","Teacher");
			
		System.out.println("JSON variable: " + request);
		System.out.println("JSON variable1: " + request.toJSONString());
		
		given().
		    body(request.toJSONString()).
		when().
		    put("https://reqres.in/api/users/2").
		then().
		   statusCode(200).log().all();
		    
	}

    @Test
    public void test_4_patch() {
		
		JSONObject request = new JSONObject();
	    request.put("name", "Raddison");
		request.put("job","Teacher");
			
		System.out.println("JSON variable: " + request);
		System.out.println("JSON variable1: " + request.toJSONString());
		
		given().
		    header("Content-Type","application/json").
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
		    body(request.toJSONString()).
		when().
		    patch("https://reqres.in/api/users/2").
		then().
		   statusCode(200).log().all();
		    
	}
    @Test
    public void test_5_delete() {

		when().
		    delete("https://reqres.in/api/users/2").
		then().
		   statusCode(204).log().all();
		    
	}



}
