package restAssuredHandsOn;

import java.io.IOException;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record.ForDefinedMethod.WithAnnotationDefaultValue;

import static org.hamcrest.Matchers.*;

public class RestAssuredAuto {
	
	static Response response = null;
	static JsonPath jsonpath = null;
	String token ;
	
	@Test(priority = 2)
	public void GET_RestAssuredAutoTest() throws IOException{
		
		try {
			
			String baseURIGet = "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/dashboarddata/status?status=NON_COMM";
			
			/*
			 * RestAssured.baseURI =
			 * "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/dashboarddata/status?status=NON_COMM";
			 * 
			 * RequestSpecification httprequest = RestAssured.given();
			 * httprequest.header("content-type","application/json");
			 * httprequest.header("Authorization",
			 * "Bearer 8f0e62e6-b391-4416-90a7-88574ff64582"); Response httpresponse =
			 * httprequest.request(Method.GET);
			 * 
			 * String responsebody = httpresponse.getBody().asString();
			 * 
			 * System.out.println("Body --> " + responsebody);
			 * 
			 * int statuscode = httpresponse.getStatusCode();
			 * Assert.assertEquals(statuscode, 200);
			 */
			
			response = given()
			.header("content-type","application/json")
			.header("Authorization","Bearer "+token)
			.when()
			.get(baseURIGet)
			.then()
			.assertThat()
			.statusCode(200)
			.extract()
			.response();
			
			
			  String custname = response.path("customerName").toString();
			  System.out.println("Customer Name --> "+custname);
			  
			  String fullbody = response.getBody().asString();
			  System.out.println("Body --> "+fullbody);
			  
			  String activeVehicles = response.path("activeVehicles").toString();
			  System.out.println("Active vehicles --> "+activeVehicles);
			 
			
			jsonpath = response.jsonPath();
			String featurelist = jsonpath.getString("featureList");
			System.out.println(featurelist);
			
		}catch(Exception e) {
			
		}
	}
	
	@Test(priority = 1)
	public void POST_RestAssuredAutoTest() throws IOException{
		try {
			String baseURIPost = "http://avtmgw.iot1.shared.eu-west-1.qa.aws.vgthosting.net:42680/avtmgw/Eicher";
			response = given()
					.header("Accept","application/json")
					.contentType("multipart/form-data")
					.multiPart("loginData","{\"userId\":\"koushic.kannan@consultant.volvo.com\",\"password\":\"suptool@123\"}")
					.when()
					.post(baseURIPost)
					.then()
					.assertThat()
					.statusCode(200)
					.extract()
					.response();
			
			jsonpath = response.jsonPath();
			token = jsonpath.getString("token");
			System.out.println("Token --> "+ token);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
