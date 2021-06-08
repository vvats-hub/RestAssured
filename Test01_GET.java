


import org.testng.Assert;
import org.testng.annotations.Test;

//normal import
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01_GET {
	
	@Test
	void test_01() {
		
		//non static 
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
				
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int StatusCode = response.getStatusCode();
		
		//pass case
		Assert.assertEquals(StatusCode, 200);
		
		//fail case		
		//Assert.assertEquals(StatusCode, 201);
	}
	
	

}
