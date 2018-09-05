package com.DropBox.Pages;

import com.DropBox.Pageobjects.PageObjects;
import com.DropBox.actions.Action;
import com.OptileTaskTestNg.Testng;

public class LoginPage extends Testng{
	
	
	//WebDriver driver;
	
	Action actions = new Action();
	PageObjects reposit = new PageObjects();
	
	
	public void englishPagelogin() throws Exception
	{
		actions.Click(reposit.EnglishSignInButton, "Click", driver, TempResultFile, "Clicking on Sign In");
	}
	public void germanPagelogin() throws Exception 
	{
		actions.Click(reposit.GermanSignInButton, "Click", driver, TempResultFile, "Clicking on Sign In");
	}
	
	public void loginUser(String Username,String Password) throws Exception
	{
		
		actions.ClearTex(reposit.emailid, driver);
		actions.enterText(reposit.emailid, Username, driver, TempResultFile, "Entering email id");
		
		actions.ClearTex(reposit.Password, driver);
		actions.enterPassword(reposit.Password, Password, driver, TempResultFile, "Entering Password");
		
		actions.Click(reposit.LoginInButton, "Click", driver, TempResultFile, "Clicking on Sign In");
	}
	
	public void VerifyEnglishErrorMsgWithoutCredentials(String Error) throws Exception
	{
		actions.Click(reposit.LoginInButton, "Click", driver, TempResultFile, "Clicking on Sign In");
		
		actions.VerifyText(reposit.ErrorMsg, Error, driver, TempResultFile, "Verifying Error Message");
		
	}
	public void VerifyEnglishErrorMsg(String Error) throws Exception
	{
		actions.VerifyText(reposit.ErrorMsg, Error, driver, TempResultFile, "Verifying Error Message");
		
	}
	
	public void VerifyGermanErrorMsgWithoutCredentials(String Error) throws Exception
	{
		actions.Click(reposit.LoginInButton, "Click", driver, TempResultFile, "Clicking on Sign In");
		
		actions.VerifyText(reposit.ErrorMsg, Error, driver, TempResultFile, "Verifying Error Message");
		
	}
	
	public void VerifyGermanErrorMsg(String Error) throws Exception
	{
		actions.VerifyText(reposit.ErrorMsg, Error, driver, TempResultFile, "Verifying Error Message");
		
	}
	
	public void VerifyUserLogged() throws Exception
	{
		actions.VerifyText(reposit.Home, "Home", driver, TempResultFile, "Verifying User logged to DropBox");
		
		actions.Click(reposit.UserIcon, "Click", driver, TempResultFile, "Clicking on User Icon");
		
		actions.VerifyText(reposit.ChangePhoto, "Change photo", driver, TempResultFile, "Verifying User logged to DropBox");
		
	}
	
	
	public void logout() throws Exception
	{
		
		actions.Click(reposit.UserIcon, "Click", driver, TempResultFile, "Clicking on User Icon");
		
		actions.Click(reposit.Logout, "Click", driver, TempResultFile, "Clicking on Logout");
	}
	
	public void Onlylogout() throws Exception
	{
		
		actions.Click(reposit.Logout, "Click", driver, TempResultFile, "Clicking on Logout");
	}
	
	public void launch() throws Exception
	{
		actions.browserLaunch("https://www.dropbox.com/", driver, TempResultFile, "Launching browser");
	}
	
	
}
