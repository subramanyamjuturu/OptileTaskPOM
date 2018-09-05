package com.DropBox.Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.DropBox.Pageobjects.PageObjects;
import com.DropBox.Results.ResultsClass;
import com.DropBox.actions.Action;
import com.OptileTaskTestNg.Testng;

public class UploadPage extends Testng{

	Action actions = new Action();
	PageObjects reposit = new PageObjects();
	static ResultsClass report = new ResultsClass();
	String ObjectPropertiesArray [] ;

	String FilePath = strAbsolutePath+"\\FileUpload\\DummyFile.txt";

	String FileName [] =FilePath.split("\\\\FileUpload\\\\");

	public void uploadFile() throws Exception
	{
		actions.Click(reposit.Home, "Click", driver, TempResultFile, "Clicking on upload button");

		actions.Click(reposit.UploadButton, "Click", driver, TempResultFile, "Clicking on upload button");

		actions.Click(reposit.UploadFile, "Click", driver, TempResultFile, "Clicking on upload file");

		StringSelection ss = new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

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

		actions.Click(reposit.DropBoxInPopUp, "Click", driver, TempResultFile, "Clicking on DropBox in pop up");

		actions.Click(reposit.UploadButtonInPopUp, "Click", driver, TempResultFile, "Clicking on upload button in pop up");

		actions.Click(reposit.ViewDetails, "Click", driver, TempResultFile, "Clicking on ViewDetails");

		actions.Click(reposit.Done, "Click", driver, TempResultFile, "Clicking on Close");
		
		Thread.sleep(6000);

		ObjectPropertiesArray = reposit.FileList.split("@@@");

		List<WebElement> ele = driver.findElements(By.xpath(ObjectPropertiesArray[1]));

		for(int i=0;i<ele.size();i++)
		{
			System.out.println(ele.get(i).getText());
			System.out.println(FileName[1]);
			if(ele.get(i).getText().equalsIgnoreCase(FileName[1]))
			{
				report.ResultWrite(TempResultFile, "verifying File uploaded sucessfully",FileName[1],"verifying",ele.get(i).getText(),"Pass",driver,true);
				break;
			}
			else if(i==ele.size())
			{
				report.ResultWrite(TempResultFile, "verifying File uploaded sucessfully",FileName[1],"verifying",ele.get(i).getText(),"Fail",driver,true);
			}
		}





	}

}
