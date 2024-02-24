package com.api.JsonValidation;
 
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
 
public class ValidateJSON {
	
	// Method to validate the response against a JSON schema
	public static void validateResponseAgainstSchema(String responseBody, String jsonSchema) {
		try {
			// Loading the response and schema into JSON nodes
			JsonNode responseJson = JsonLoader.fromString(responseBody);
			JsonNode schemaJson = JsonLoader.fromString(jsonSchema);
			
			// Creating a JSON schema factory
			JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
			JsonSchema schema = factory.getJsonSchema(schemaJson);
			
			// Validating the response against the JSON schema
			ProcessingReport report = schema.validate(responseJson);
			
			// Checking if the validation was successful
			if (!report.isSuccess()) {
				// Throwing an exception if the response does not match the JSON schema
				throw new AssertionError("Response does not match JSON schema: \n" + report);
			}
		} catch (ProcessingException | IOException e) {
			// Handling any processing or IO exceptions
			throw new RuntimeException(e);
		}
	}
}

 