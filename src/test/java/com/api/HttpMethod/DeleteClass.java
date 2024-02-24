package com.api.HttpMethod;

import static io.restassured.RestAssured.given;

import com.api.RestSpecUtil.RestSpecHelper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DeleteClass {

	// Method to perform a DELETE request
	public static void deleteData(Object[] req) {
		// Creating a request specification based on the provided request array
		RequestSpecification reqSpec = RestSpecHelper.createRequestSpecification(req[0].toString());

		// Setting the response validation based on the provided request array
		ResponseSpecification validation = RestSpecHelper.createResponseSpecification(req);

		// Making a DELETE request and validating the response
		Response response = given().spec(reqSpec).when().delete();
		response.then().spec(validation);
	}

}
