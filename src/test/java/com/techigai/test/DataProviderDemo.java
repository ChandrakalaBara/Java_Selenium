package com.techigai.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@DataProvider
	public Object[][] getTestData() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "chandu";
		data[0][1] =  "chandu123";
		
		data[1][0] = "kala";
		data[1][1] = "kala12";
		
		data[2][0] = "ckala";
		data[2][1] = "ckala12";
		
		return data;
		
	}
	
	
	@Test(dataProvider="getTestData")
	public void setData(String userName, String password) {
		System.out.println("username"+userName);
		System.out.println("password"+password);
	}
	
}
