package com.influents.maintestcases;

import org.testng.annotations.Test;

import com.influents.UtilitiesVariable.GlobalVariables;
import com.influents.UtilitiesVariable.GlobalXPath;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class CheckingTestDate {
	@Test
	public void checkingDateTest() {

		try {
			
			WebDriverWait driverWait = new WebDriverWait(GlobalVariables.chromeDriver_Main, 40);
			GlobalVariables.chromeDriver_Main.get("https://www.camperbug.co.uk/liltango");
			JavascriptExecutor executor = (JavascriptExecutor)GlobalVariables.chromeDriver_Main;
			GlobalVariables.chromeDriver_Main.manage().window().maximize();
			GlobalVariables.chromeDriver_Main.manage().getCookies().clear();
			Thread.sleep(1000);
			
			//Point point = GlobalVariables.chromeDriver_Main.findElement(By.xpath("/html/body/main/div/div/div/div[3]/div[3]/div/div[2]/div/div[1]/div[2]/div/div[1]/div/div/span[1]")));
			
			WebElement element;
			element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/div/div[3]/div[3]/div/div[2]/div/div[1]/div[2]/div/div[1]/div/div/span[1]")));
			
			((JavascriptExecutor) GlobalVariables.chromeDriver_Main).executeScript("arguments[0].scrollIntoView(true);", element);
			
			Thread.sleep(2000);
			
			WebElement startdateselect = GlobalVariables.chromeDriver_Main.findElement(By.xpath("//div[contains(@id,'dp')]/div/div[1]/table/tbody/tr[1]/td[6]"));
			Thread.sleep(1000);
			startdateselect.click();
			
			
			WebElement enddateselect = GlobalVariables.chromeDriver_Main.findElement(By.xpath("//div[contains(@id,'dp')]/div/div[4]/table/tbody/tr[3]/td[5]"));
			Thread.sleep(1000);
			enddateselect.click();
			
			
			
			//
			
			System.out.println("Visibility Located now");
			
			
			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {

		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\KishanWorks\\TrainingLecturesApi\\Inflients_AutomationTestScripts\\src\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			// 1-Allow, 2-Block, 0-default
			options.setExperimentalOption("prefs", prefs);

			GlobalVariables.chromeDriver_Main = new ChromeDriver(options);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error into the beforemethod of test" + this.getClass());
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

}
