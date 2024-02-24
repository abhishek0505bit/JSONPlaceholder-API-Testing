package com.api.HttpMethod;

import static io.restassured.RestAssured.given;

import com.api.JsonValidation.ValidateJSON;
import com.api.RestSpecUtil.RestSpecHelper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PostClass {

	// Method to perform a POST request
	public static void postData(Object[] req) {

		// Creating a request specification based on the provided request array
		RequestSpecification reqSpec = RestSpecHelper.createRequestSpecification(req[0].toString());

		// Setting the response validation based on the provided request array
		ResponseSpecification validation = RestSpecHelper.createResponseSpecification(req);
		
		// Making a POST request with the specified request body and validating the
		// response
		Response response = given().spec(reqSpec).body(req[2].toString()) // Setting the request body
				.when().post();
		response.then().spec(validation);

		// Validating the json response
		ValidateJSON.validateResponseAgainstSchema(response.getBody().asString(), req[7].toString());

	}

}
