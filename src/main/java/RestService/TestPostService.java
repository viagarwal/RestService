package RestService;

import static com.jayway.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TestPostService {

	@Test
	public void test() {

		Response res = given().auth()
				.basic("loginName", "password").when()
				.post("https://www.facebook.com/ajax/chat/buddy_list.php");
		res.contentType().equals("application/json1");
		Assert.assertEquals(String.valueOf(res.getStatusCode()), "200");

	}

}
