
/////////Static import/////////

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

//normal import
//import static io.restassured.RestAssured;

// static import
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test02_GET2 {
	
	@Test
	void test_01() {
		
		//non static 
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		//static import :
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int StatusCode = response.getStatusCode();
		
		//pass case
		AssertJUnit.assertEquals(StatusCode, 200);
		
		//fail case		
		//Assert.assertEquals(StatusCode, 201);
	}
	
	@Test
	void test_02() {
		
		//statement
		given()
		    .get("https://reqres.in/api/users?page=2")
	    .then()
		     .statusCode(200)
		     .body("data.id[0]", equalTo(7));
	}
	
	

}
