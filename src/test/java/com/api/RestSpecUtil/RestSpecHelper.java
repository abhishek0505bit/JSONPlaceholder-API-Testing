package com.api.RestSpecUtil;

import com.api.Specification.Specifications;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestSpecHelper {

    // Method to create a request specification
    public static RequestSpecification createRequestSpecification(String requestParam) {
        // Setting and returning the request specification using the provided request parameters
        RequestSpecification reqSpec = Specifications.setRequestSpecification(requestParam);
        return reqSpec;
    }

    // Method to create a response specification
    public static ResponseSpecification createResponseSpecification(Object[] requestParam) {
        // Setting and returning the response specification using the provided request parameters
        ResponseSpecification validation = Specifications.setResponseSpecification(requestParam);
        return validation;
    }
}