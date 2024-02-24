package com.api.TestUtil;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.HttpMethod.DeleteClass;
import com.api.HttpMethod.GetClass;
import com.api.HttpMethod.PatchClass;
import com.api.HttpMethod.PostClass;
import com.api.HttpMethod.PutClass;
import com.api.Reading.ExcelReader;

public class Main {

	@DataProvider(name = "Send Data")
	public static Object[][] decideing() {
		List<List<Object>> list = ExcelReader.readRequest();// Reading input data from excel file
		Object arr[][] = new Object[list.size()][];// Creating an array which has no. of rows=list.size() and no. of
													// columns= not specified
//		list.size = excelsheet list size ie, no. of rows in our excel sheet

		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i).toArray();// filling the array with input data i.e, stored in the list
//			System.out.println(arr[i][0]);
		}
		return arr; // returning the input data array
	}

	@Test(dataProvider = "Send Data")
	void tests(Object request[]) {// request = whole information of the row received from the data provider which
									// is array of Objects but in request[1] ,we have stored the http requests
		String match = request[1].toString();// Extracting the HTTP request type from the input data
		System.out.println(match);
		switch (match) {
		case "GET":
			GetClass.getData(request);// invoking a method to invoke a get request
			break;
		case "POST":
			PostClass.postData(request);// invoking a method a invoke a post request
			break;
		case "PUT":
			PutClass.putData(request);// invoking a method to invoke a put request
			break;
		case "PATCH":
			PatchClass.patchData(request);// invoking a method to invoke a patch request
			break;
		case "DELETE":
			DeleteClass.deleteData(request);// invoking a method to invoke a delete request
			break;
		default:
			System.out.println("Nothing Matched. INVALID HTTP REQUEST!");// this handles invalid input
		}
	}
}