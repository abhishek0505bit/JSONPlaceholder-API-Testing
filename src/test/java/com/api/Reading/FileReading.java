package com.api.Reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReading {

	// Method to retrieve base URL from a properties file
	public static String getBaseUrl() {
		String baseUrl = null;
		Properties obj = null;
		try {
			// Define the file path for the properties file
			String filePath = System.getProperty("user.dir") + "//src//test//resources//baseURL.properties";

			// Read the properties file
			FileInputStream objfile = new FileInputStream(filePath);
			obj = new Properties();
			obj.load(objfile);

			// Get the base URL from the properties file
			baseUrl = obj.getProperty("baseURL");

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Return the retrieved base URL
		return baseUrl;
	}
}
