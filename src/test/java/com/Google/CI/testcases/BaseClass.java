package com.Google.CI.testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//import java.util.logging.log4j;
//import org.apache.logging.log4j.LogManager;
//mport org.apache.logging.log4js.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Google.CI.pageObjects.LoginPage;
import com.Google.CI.pageObjects.UserPage;
import com.Google.CI.utilities.DataProviders;

public class BaseClass{
	public static WebDriver driver;
	//public Logger logger=LogManager.getLogger(this.getClass());
	//public Logger logger=LogManager.getLogger(BaseClass.class);
	//public Properties p;
    public static Properties prop;
    
	@BeforeClass
    void setup() throws InterruptedException, IOException {
		//**************************************************************
		prop=new Properties();
    	//-------------------------------------
    	
    	prop.setProperty("br","Chrome");
		prop.setProperty("url","https://online.actitime.com/anileshsubscriptiongmailcom/login.do");
		prop.setProperty("username1","anileshsubscription@gmail.com");
		prop.setProperty("pwd1","automation@123");
		prop.setProperty("expectedResult1","Success");
		prop.setProperty("username2","anileshsubscriptions@gmail.com");
		prop.setProperty("pwd2","automation@123");
		prop.setProperty("expectedResult2","Failure");
    	String filePath=System.getProperty("user.dir")+"\\data\\examples.properties";
		FileOutputStream file=new FileOutputStream(filePath);
		prop.store(file, "Sample data in properties file");
		//file.close();
		//prop.store(file, "Sample data in properties file...");
		//file.close();
		System.out.println(filePath);
		//FileInputStream file1=new FileInputStream(filePath);
		//prop.load(file1);
		//file1.close();
		System.out.println(prop.getProperty("username1"));
		System.out.println(prop.getProperty("pwd1"));
		
			//***********************************************************************
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));//reading url from config properties file
	
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
@Test(dataProvider="loginData")//where this Logindata is available in DataProviders.class
	void testLogin(String stremail,String strPwd) throws InterruptedException {
		try {
			//DataProviders dp=new DataProviders();
			performLogin(stremail,strPwd);
		    Thread.sleep(2000);
		   }//try
		catch(Exception e) {
			System.out.println("This is the error :"+e.getMessage());
			System.out.println(e.getStackTrace());
			Assert.fail();
		 }//catch
	  }//testLogin
	public void performLogin(String username, String password) {
        // Dummy logic for demonstration
	 try {
		 LoginPage lp=new LoginPage(BaseClass.driver);
		    lp.setUserName(username);
			lp.setPwd(password);
			lp.clickLogin();
	 }catch(Exception e) {
		 
		 //System.exit(0);
	 }
	}
	@Test
	 void ValidatePage() throws InterruptedException {
	    	Thread.sleep(2000);
	    	UserPage up=new UserPage(BaseClass.driver);
	    	System.out.println(up.myAccountGetDetails());
	    	if(up.myAccountGetDetails().equals("AM")) {
	    		Assert.assertTrue(true);
	    	}
			
	  }
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
