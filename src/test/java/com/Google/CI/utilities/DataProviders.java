package com.Google.CI.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;

import com.Google.CI.testcases.BaseClass;

	public class DataProviders extends BaseClass {
		//****************************************
		
//		 /Properties prop;
	    @DataProvider(name = "loginData")
	    public Object[][] getLoginData() throws IOException {
            String filePath=System.getProperty("user.dir")+"\\data\\examples.properties";
		    System.out.println(filePath);
			FileInputStream file1=new FileInputStream(filePath);
			prop.load(file1);
			//************************************************************
	        return new Object[][] {
	            // username, password, expectedResult
	            {BaseClass.prop.getProperty("username1"),BaseClass.prop.getProperty("pwd1")},
	            {BaseClass.prop.getProperty("username2"),BaseClass.prop.getProperty("pwd2")},
	            
	        };
	        
	    }
	    
	}

