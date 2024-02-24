package com.api.HttpMethod;

import static io.restassured.RestAssured.given;

import com.api.JsonValidation.ValidateJSON;
import com.api.RestSpecUtil.RestSpecHelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetClass {

	public static Response response;

	// Method to perform a GET request
	public static void getData(Object request[]) {
		// Allowing relaxed HTTPS validation
		RestAssured.useRelaxedHTTPSValidation();

		// Creating a request specification based on the provided request array
		// RequestSpecification reqSpec =
		RequestSpecification reqSpec = RestSpecHelper.createRequestSpecification(request[0].toString());

		// Printing the request endpoint
		System.out.println(request[0]);

		// Setting the response validation based on the provided request array
		ResponseSpecification validation = RestSpecHelper.createResponseSpecification(request);

		// Storing the response in the variable for further use
		// Making a GET request and validating the response
		response = given().spec(reqSpec).when().get();
		response.then().spec(validation);

		// Validating the response body against the provided schema
		ValidateJSON.validateResponseAgainstSchema(response.getBody().asString(), request[7].toString());
	}
}