package com.OptileTaskTestNg;

import org.testng.annotations.Test;

import com.DropBox.Results.ResultsClass;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Testng {

	public String strAbsolutePath =new File("").getAbsolutePath();
	public String ResourcePath = strAbsolutePath+"\\Resources\\";
	public String ChromeDriverPath = ResourcePath+"chromedriver.exe";
	public String ResultPath = strAbsolutePath+"\\Results";
	public String TempResult=ResultPath+"\\TemproryResultFile";
	public static String TempResultFile;


	ResultsClass Report = new ResultsClass();
	public static WebDriver driver;

	@Test
	public void f() {
	}
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);	
		//Launching chrome Browser
		driver = new ChromeDriver();
		
		System.out.println("Done");
		//Mathematical Random  number function just for external Report purpose
		Random rand = new Random();
		double  n = rand.nextInt(50)*1.13;
		
		//This line is for saving result in Result folder In our project location
		TempResultFile =TempResult+n+".htm";
		
		//This is for external Report for the Automation execution and it contains detailed step by step execution line which we performed in automation including with screenshots
		Report.HTMLInitialisation(TempResultFile, ResultPath);


	}
	
	

	@AfterClass
	public void afterClass() throws IOException, InterruptedException {
		driver.quit();
		
		Report.FinalResultWrite(TempResultFile);
	}

}
