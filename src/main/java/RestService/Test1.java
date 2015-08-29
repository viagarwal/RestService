package RestService;

import static com.jayway.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class Test1 {

	@Test
	public void test() {
		Response res = get("https://www.facebook.com");
		Assert.assertEquals(200, res.getStatusCode());
		String json = res.asString();
		System.out.println(json);
	}

}
