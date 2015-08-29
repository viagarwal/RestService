package RestService;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;

public class TestMD5 {

	@Test
	public void test() {
		given().parameters("text", "test").when()
				.get("http://md5.jsontest.com").then()
				.body("md5", equalTo("098f6bcd4621d373cade4e832627b4f6"));
	}

	@Test
	public void test2() {
		baseURI = "http://freegeoip.net:80/";
		when().get("/json/yahoo.com").then().statusCode(200).log().all()
				.body("country_code", equalTo("US")

				);

	}

	@Test
	public void test3() {
		Response res = get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/");
		Assert.assertEquals(String.valueOf(res.statusCode()).trim(), "200");
		String str = res.asString();
		XmlPath xmlPath = new XmlPath(str).setRoot("customer");
		String customerId = xmlPath.getString("id");
		String firstName = xmlPath.getString("firstName");
		String lastName = xmlPath.getString("lastName");
		Assert.assertEquals(customerId, "12212");
		Assert.assertEquals(firstName, "John");
		Assert.assertEquals(lastName, "Smith");

	}

}
