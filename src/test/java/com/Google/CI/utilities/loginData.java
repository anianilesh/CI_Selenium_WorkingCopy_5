
package com.Google.CI.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;

import com.Google.CI.testcases.BaseClass;

	public class loginData extends BaseClass {
		//****************************************
		
//		 /Properties prop;
	    @DataProvider(name = "loginData",indices= {0,1})
	    public Object[][] getLoginData() throws IOException {
	    	String filePath=System.getProperty("user.dir")+"\\data\\examples.properties";
			FileOutputStream file=new FileOutputStream(filePath);
			prop.store(file, "Sample data in properties file");
			System.out.println(filePath);
			FileInputStream file1=new FileInputStream(filePath);
			prop.load(file1);
			//************************************************************
	        Object data[][]={
	            // username, password, expectedResult
	            {BaseClass.prop.getProperty("username1"),BaseClass.prop.getProperty("pwd1")},
	            {BaseClass.prop.getProperty("username2"),BaseClass.prop.getProperty("pwd2")},
	            
	        };
			return data;
	        
	    }
	    
	}


