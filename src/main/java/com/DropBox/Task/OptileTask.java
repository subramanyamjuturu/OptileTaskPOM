package com.DropBox.Task;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DropBox.Pageobjects.PageObjects;
import com.DropBox.Pages.CreateFolder;
import com.DropBox.Pages.LoginPage;
import com.DropBox.Pages.UploadPage;
import com.DropBox.actions.Action;
import com.OptileTaskTestNg.Testng;

public class OptileTask extends Testng
{
	Action action = new Action();
	PageObjects reposit = new PageObjects();
	LoginPage login = new LoginPage();
	UploadPage uploadFile = new UploadPage();
	CreateFolder createfolder = new CreateFolder();
	
	@Parameters({"Username","Password","InvalidUsername","InvalidPassword"})
	@Test(priority=0)
	public void loginLogoutScenerio(String Username,String Password,String InvalidUsername,String InvalidPassword) throws Exception
	{
		
		//Launching application
		login.launch();
		String source =action.pageSource(driver);
		
		if(source.contains("xml:lang=\"de\""))
		{
			//clicking on signin button based on german page or english page
			login.germanPagelogin();
			//verifying error message in german language when we failed to enter credentials
			login.VerifyGermanErrorMsgWithoutCredentials("Geben Sie Ihre E-Mail-Adresse ein");
			//loging to the application with the credentails given in xml file
			login.loginUser(Username,InvalidPassword);
			//verifying error messages in german language when we enter incorrect details
			login.VerifyGermanErrorMsg("Ungültige E-Mail-Adresse oder ungültiges Kennwort");
			
		}
		else if(source.contains("xml:lang=\"en\"")){
			//clicking on signin button based on german page or english page
			login.englishPagelogin();
			//verifying error message in English language when we failed to enter credentials
			login.VerifyEnglishErrorMsgWithoutCredentials("Please enter your email");
			//loging to the application with the credentails given in xml file
			login.loginUser(Username,InvalidPassword);
			//verifying error messages in german language when we enter incorrect details
			login.VerifyEnglishErrorMsg("Invalid email or password");
			
		}
		//loging to the application with the credentails given in xml file
		login.loginUser(Username, Password);
		//verifying whether user logged to application or not
		login.VerifyUserLogged();
		// loging out from application
		login.Onlylogout();
	}
	
	@Parameters({"Username","Password"})
	@Test(priority=1)
	public void uploadFileFunctionality(String Username,String Password) throws Exception
	{
		
		//launching application
		login.launch();
		String source =action.pageSource(driver);
		
		if(source.contains("xml:lang=\"de\""))
		{
			//clicking on signin button based on german page or english page
			login.germanPagelogin();
			
		}
		else if(source.contains("xml:lang=\"en\"")){
			//clicking on signin button based on german page or english page
			login.englishPagelogin();
		}
		//loging to the application with the credentails given in xml file
		login.loginUser(Username, Password);
		//verifying whether user logged to application or not
		login.VerifyUserLogged();
		// uploading the file
		uploadFile.uploadFile();
		// loging out from application
		login.logout();
		
	}
	
	@Parameters({"Username","Password"})
	@Test(priority=2)
	public void createFolderFunctionality(String Username,String Password) throws Exception
	{
		// launching application
		login.launch();
		String source =action.pageSource(driver);
		
		if(source.contains("xml:lang=\"de\""))
		{
			//clicking on signin button based on german page or english page
			login.germanPagelogin();
			
		}
		else if(source.contains("xml:lang=\"en\"")){
			//clicking on signin button based on german page or english page
			login.englishPagelogin();
		}
		//loging to the application with the credentails given in xml file
		login.loginUser(Username, Password);
		//verifying whether user logged to application or not
		login.VerifyUserLogged();
		// creating folder
		createfolder.createFolderFunctionality();
		// loging out from application
		login.logout();
		
	}
	
	@Parameters({"Username","Password"})
	@Test(priority=3)
	public void createDeleteFolderFunctionality(String Username,String Password) throws Exception
	{
		
		login.launch();
		String source =action.pageSource(driver);
		
		if(source.contains("xml:lang=\"de\""))
		{
			//clicking on signin button based on german page or english page
			login.germanPagelogin();
			
		}
		else if(source.contains("xml:lang=\"en\"")){
			//clicking on signin button based on german page or english page
			login.englishPagelogin();
		}
		
		//loging to the application with the credentails given in xml file
		login.loginUser(Username, Password);
		//verifying whether user logged to application or not
		login.VerifyUserLogged();
		// creating and deleting folder
		createfolder.deleteCreatedFolderFunctionality();
		// loging out from application
		login.logout();
		
	}
	@Parameters({"Username","Password"})
	@Test(priority=4)
	public void renameCreatedFolderFunctionality(String Username,String Password) throws Exception
	{
		// launching application
		login.launch();
		String source =action.pageSource(driver);
		
		if(source.contains("xml:lang=\"de\""))
		{
			//clicking on signin button based on german page or english page
			login.germanPagelogin();
			
		}
		else if(source.contains("xml:lang=\"en\"")){
			//clicking on signin button based on german page or english page
			login.englishPagelogin();
		}
		
		//loging to the application with the credentails given in xml file
		login.loginUser(Username, Password);
		//verifying whether user logged to application or not
		login.VerifyUserLogged();
		// creating and renaming the folder
		createfolder.renameCreatedFolderFunctionality();
		// loging out from application
		login.logout();
		
	}

}
