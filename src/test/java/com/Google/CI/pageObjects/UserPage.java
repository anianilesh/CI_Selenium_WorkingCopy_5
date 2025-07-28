package com.Google.CI.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Google.CI.pageObjects.BasePage;
public class UserPage extends BasePage{

public UserPage(WebDriver driver) {
	
		super(driver);
		System.out.println("Im userpage : Im 3rd in number");
		// TODO Auto-generated constructor stub
	}
   @FindBy(xpath="//*[@id=\"topnav\"]/tbody/tr[1]/td[7]/div/div[2]/a/span")
   WebElement wbLogo;

   public String  myAccountGetDetails() {
	   String strTxt;
	   strTxt=wbLogo.getText();
	   return strTxt;
    }
}
