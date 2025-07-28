package com.Google.CI.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Google.CI.pageObjects.LoginPage;
import com.Google.CI.pageObjects.UserPage;
import com.Google.CI.utilities.DataProviders;
import com.Google.CI.testcases.BaseClass;
public class TC_001_LoginDDT extends BaseClass {
	@Test(priority=1,dataProvider="loginData",dataProviderClass = DataProviders.class)//where this Logindata is available in DataProviders.class
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
	 @Test(priority=2)
	 void ValidatePage() throws InterruptedException {
	    	Thread.sleep(2000);
	    	UserPage up=new UserPage(BaseClass.driver);
	    	System.out.println(up.myAccountGetDetails());
	    	if(up.myAccountGetDetails().equals("AM")) {
	    		Assert.assertTrue(true);
	    	}
			
	  }
	 
	 public void performLogin(String username, String password) {
	        // Dummy logic for demonstration
		 try {
			 LoginPage lp=new LoginPage(BaseClass.driver);
			    lp.setUserName(username);
				lp.setPwd(password);
				lp.clickLogin();
				Thread.sleep(2000);
				BaseClass.driver.findElement(By.xpath("//*[@id=\"logoutLink\"]")).click();
		 }catch(Exception e) {
			 
			 //System.exit(0);
		 }
		    
		}
}
