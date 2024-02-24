package com.api.HttpMethod;

import static io.restassured.RestAssured.given;

import com.api.JsonValidation.ValidateJSON;
import com.api.RestSpecUtil.RestSpecHelper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PutClass {

	// Method to perform a PUT request
	public static void putData(Object[] req) {

		// Creating a request specification based on the provided request array
		RequestSpecification reqSpec = RestSpecHelper.createRequestSpecification(req[0].toString());

		// Setting the response validation based on the provided request array
		ResponseSpecification validation = RestSpecHelper.createResponseSpecification(req);

		// Making a PUT request with the specified request body and validating the
		// response
		Response response = given().spec(reqSpec).body(req[2].toString()) // Setting the request body
				.when().put();
		response.then().spec(validation);

		// Validating the response
		ValidateJSON.validateResponseAgainstSchema(response.getBody().asString(), req[7].toString());

	}

}
