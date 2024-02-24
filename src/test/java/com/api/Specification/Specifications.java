package com.api.Specification;

import static org.hamcrest.Matchers.lessThan;

import com.api.Reading.FileReading;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

	// Method to set up the request specification for API calls
	public static RequestSpecification setRequestSpecification(String endpoint) {
		// Obtain the base URL from the FileReading class using the getBaseUrl method
		String base = FileReading.getBaseUrl(); // getBaseURl() method of FileReading class is invoked, which returns
												// the URL of the website
		RequestSpecification request = new RequestSpecBuilder().setBaseUri(base + endpoint) // Set the base URI for the
																							// request
				.addHeader("Content-type", "application/json") // Add a header for the content type
				.build(); // Build the request specification

		return request; // Return the request specification
	}

	// Method to set up the response specification for API calls
	public static ResponseSpecification setResponseSpecification(Object[] res) {
		// Convert the time and status values from the Object array to their respective
		// data types
		long time = Double.valueOf((double) res[4]).longValue(); // Extract the expected response time and convert it to
																	// a long value
		int status = Double.valueOf((double) res[3]).intValue(); // Extract the expected status code and convert it to
																	// an integer
		ResponseSpecification validation = new ResponseSpecBuilder().expectResponseTime(lessThan(time)) // Set the
																										// expected
																										// maximum
																										// response time
				.expectStatusCode(status) // Set the expected status code
				.build(); // Build the response specification

		return validation; // Return the response specification
	}
}