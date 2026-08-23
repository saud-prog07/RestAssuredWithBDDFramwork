package com.POSTRestAssured;


import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TraditionalRestAssuredPost3 {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://fakestoreapi.com";
	}

	@Test
	public void testPostRequestTraditional() {

		System.out.println("=== TRADITIONAL APPROACH ===\n");

		JSONObject requestBody = new JSONObject();

		requestBody.put("id", 11);

		System.out.println("Request Body : " + requestBody.toString());

		RequestSpecification request = given();

		request.header("Content-Type", "application/json");

		request.body(requestBody.toString());

		Response response = request.post("/carts");

		int statusCode = response.getStatusCode();

		System.out.println("Status Code : " + statusCode);

		System.out.println("Complete Response : " + response.asString());

		String responseBody = response.getBody().asString();

		System.out.println("Response Body : " + responseBody);

		System.out.println("Response Status Line : " + response.getStatusLine());

		System.out.println("Response Content Type : " + response.getContentType());

		System.out.println("Response Time : " + response.getTime() + "ms");

		// Assertions

		org.testng.Assert.assertEquals(statusCode, 201, "Status Code should be 201");

		org.testng.Assert.assertTrue(responseBody.contains("11"), "Response should contain id 11");

		org.testng.Assert.assertNotNull(responseBody, "Response Body should not be null");
	}
}
