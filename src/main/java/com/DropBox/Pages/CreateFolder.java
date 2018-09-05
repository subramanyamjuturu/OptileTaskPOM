package com.DropBox.Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.DropBox.Pageobjects.PageObjects;
import com.DropBox.Results.ResultsClass;
import com.DropBox.actions.Action;
import com.OptileTaskTestNg.Testng;

public class CreateFolder extends Testng{

	Action actions = new Action();
	PageObjects reposit = new PageObjects();
	static ResultsClass report = new ResultsClass();
	String ObjectPropertiesArray [] ;

	Random rand = new Random();
	double  n = rand.nextInt(50)*1.13;



	String FolderName ="DummyFile"+n;
	String Rename ="RenameFile"+n;


	public void createFolderFunctionality() throws Exception
	{
		actions.Click(reposit.DropBoxHomeIcon, "Click", driver, TempResultFile, "Clicking on DropBox Home Icon");

		actions.Click(reposit.Files, "Click", driver, TempResultFile, "Clicking on Files");

		actions.Click(reposit.NewFolder, "Click", driver, TempResultFile, "Clicking on NewFolder");

		StringSelection ss = new StringSelection(FolderName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Thread.sleep(1000);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);

		ObjectPropertiesArray = reposit.UploadedFolderName.split("@@@");

		List<WebElement> ele = driver.findElements(By.xpath(ObjectPropertiesArray[1]));

		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(FolderName);
			if(ele.get(i).getText().equalsIgnoreCase(FolderName))
			{
				report.ResultWrite(TempResultFile, "verifying File uploaded sucessfully",FolderName,"verifying",ele.get(i).getText(),"Pass",driver,true);
				break;
			}
			else if(i==ele.size())
			{
				report.ResultWrite(TempResultFile, "verifying File uploaded sucessfully",FolderName,"verifying",ele.get(i).getText(),"Fail",driver,true);
			}
		}

	}
	
	public void deleteCreatedFolderFunctionality() throws Exception
	{

		createFolderFunctionality();
		
		actions.Click(reposit.MyFiles, "Click", driver, TempResultFile, "Clicking on MyFiles");
		
		ObjectPropertiesArray = reposit.UploadedFolderName.split("@@@");

		List<WebElement> ele = driver.findElements(By.xpath(ObjectPropertiesArray[1]));

		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(FolderName);
			
			if(ele.get(i).getText().equalsIgnoreCase(FolderName))
			{
				report.ResultWrite(TempResultFile, "verifying File uploaded sucessfully",FolderName,"verifying",ele.get(i).getText(),"Pass",driver,true);
				
				actions.Click(reposit.FileOptions, "Click", driver, TempResultFile, "Clicking on File Options");
				
				actions.Click(reposit.Delete, "Click", driver, TempResultFile, "Clicking on File Delete");
				
				actions.Click(reposit.PopUpDeleteConformation, "Click", driver, TempResultFile, "Clicking on Popup delete Conformation");
				
				Thread.sleep(3000);
				
				break;
			}
			else if(i==ele.size())
			{
				report.ResultWrite(TempResultFile, "verifying File uploaded sucessfully",FolderName,"verifying",ele.get(i).getText(),"Fail",driver,true);
			}
		}

		
		actions.Click(reposit.DeletedFiles, "Click", driver, TempResultFile, "Clicking on DeletedFiles");
		
		ObjectPropertiesArray = reposit.DeletedFileList.split("@@@");

		ele = driver.findElements(By.xpath(ObjectPropertiesArray[1]));

		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(FolderName);
			if(ele.get(i).getText().equalsIgnoreCase(FolderName))
			{
				report.ResultWrite(TempResultFile, "verifying uploaded folder is deleted sucessfully",FolderName,"verifying",ele.get(i).getText(),"Pass",driver,true);
				break;
			}
			else if(i==ele.size())
			{
				report.ResultWrite(TempResultFile, "verifying uploaded folder is deleted sucessfully",FolderName,"verifying",ele.get(i).getText(),"Fail",driver,true);
			}
		}

	}
	
	public void renameCreatedFolderFunctionality() throws Exception
	{

		createFolderFunctionality();
		
		actions.Click(reposit.MyFiles, "Click", driver, TempResultFile, "Clicking on MyFiles");
		
		ObjectPropertiesArray = reposit.UploadedFolderName.split("@@@");

		List<WebElement> ele = driver.findElements(By.xpath(ObjectPropertiesArray[1]));

		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(FolderName);
			
			if(ele.get(i).getText().equalsIgnoreCase(FolderName))
			{
				actions.Click(reposit.FileOptions, "Click", driver, TempResultFile, "Clicking on File Options");
				
				actions.Click(reposit.Rename, "Click", driver, TempResultFile, "Clicking on File Rename");
				
				StringSelection ss = new StringSelection(Rename);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				
				Thread.sleep(1000);

				Robot robot = new Robot();

				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);

				Thread.sleep(3000);
				break;
			}
			else if(i==ele.size())
			{
				report.ResultWrite(TempResultFile, "verifying file is renamed  file",FolderName,"verifying",ele.get(i).getText(),"Fail",driver,true);
			}
		}

		
		actions.Click(reposit.MyFiles, "Click", driver, TempResultFile, "Clicking on MyFiles");
		
		ObjectPropertiesArray = reposit.UploadedFolderName.split("@@@");

		ele = driver.findElements(By.xpath(ObjectPropertiesArray[1]));

		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(Rename);
			if(ele.get(i).getText().equalsIgnoreCase(Rename))
			{
				report.ResultWrite(TempResultFile, "verifying uploaded folder is renamed sucessfully",Rename,"verifying",ele.get(i).getText(),"Pass",driver,true);
				break;
			}
			else if(i==ele.size())
			{
				report.ResultWrite(TempResultFile, "verifying uploaded folder is renamed sucessfully",Rename,"verifying",ele.get(i).getText(),"Fail",driver,true);
			}
		}

	}

}
