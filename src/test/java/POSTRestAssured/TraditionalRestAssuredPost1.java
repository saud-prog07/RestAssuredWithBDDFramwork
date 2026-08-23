package com.POSTRestAssured;


import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TraditionalRestAssuredPost1 {
	
	@BeforeClass
	public void setUp() {
		//set baseURI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}
	
	@Test
	public void testPostRequestTraditional() {
		System.out.println(" === TRADITIONAL APPROACH ===\n");
		JSONObject requestBody = new JSONObject();
		requestBody.put("title", "Test Post");
		requestBody.put("body", "This is a Test Body");
		requestBody.put("userId", 1);
		System.out.println("Request Body :" + requestBody.toString());
		RequestSpecification request = given();
		request.header("Content-Type", "application/json");
		request.body(requestBody.toString());
		Response response = request.post("/posts");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code :" + response.statusCode());
		System.out.println("Complete Response :" + response.asString());
		String responseBody = response.getBody().asString();
		System.out.println("Reponse Body" + responseBody);
		String statusLine = response.getStatusLine();
		System.out.println("Response Status Line :" + statusLine);
		String contentType = response.getContentType();
		System.out.println("Response Content Type :" + contentType);
		long responseTime = response.getTime();
		System.out.println("Response Time: " + responseTime + "ms");
		org.testng.Assert.assertEquals(statusCode, 201,"Status Code should be 201");
		org.testng.Assert.assertTrue(responseBody.contains("Test Post"),"Response should contain the Title");
		org.testng.Assert.assertNotNull(responseBody,"Response Body should not be null");
		
		
		
		
	}

}