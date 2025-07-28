package com.Google.CI.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Google.CI.pageObjects.BasePage;


public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='username']")
    WebElement txt_usrname_loc;
    @FindBy(xpath="//input[@placeholder='Password']")
    WebElement txt_pwd_loc;
    @FindBy(xpath="//div[normalize-space()='Login']")
    WebElement btn_Login_loc;
    
	WebDriver driver;
	public void setUserName(String usr) {
    	txt_usrname_loc.sendKeys(usr);
    }
    public void setPwd(String pwd) {
    	txt_pwd_loc.sendKeys(pwd);
    
    }
    public void clickLogin() {
    	btn_Login_loc.click();
     }
}

