package com.influents.maintestcases;

import org.testng.annotations.Test;

import com.influents.UtilitiesVariable.GlobalVariables;
import com.influents.UtilitiesVariable.GlobalXPath;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Login_NegativeTestCase {
	@Test
	public void negative_LoginTestcase() {
		try {
			FileReader fileReader = new FileReader("config/selenium.properties");
			Properties properties = new Properties();
			properties.load(fileReader);
			
			GlobalVariables.chromeDriver_Main.get(GlobalXPath.login_Url);
			GlobalVariables.chromeDriver_Main.manage().window().maximize();
			GlobalVariables.chromeDriver_Main.manage().getCookies().clear();
			Thread.sleep(1000);
			WebDriverWait driverWait = new WebDriverWait(GlobalVariables.chromeDriver_Main, 40);
			driverWait.until(ExpectedConditions.elementToBeClickable(By.name("email")));

			if (GlobalVariables.chromeDriver_Main.findElement(By.name("email")).isEnabled()) {
				System.out.println("Element is Visible");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.name("email")).sendKeys("testuser@arcfix.com");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.name("password")).sendKeys("password");
				
				
				Thread.sleep(1000);
				// Login button Click
				System.out.println(properties.getProperty("login_ButtontoLogin"));

				//GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Login_Button)).click();
				GlobalVariables.chromeDriver_Main.findElement(By.xpath(properties.getProperty("login_ButtontoLogin"))).click();
				
			}

			System.out.println("Value Input is done Clicking Login now");
			// GlobalVariables.chromeDriver_Main.findElement(By.name("password")).sendKeys("password");
			Thread.sleep(1000);

			// Login button Click
			//GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Login_Button)).click();
			

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
		try {
			GlobalVariables.chromeDriver_Main.quit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error into the beforemethod of test" + this.getClass());
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {

	}

}
