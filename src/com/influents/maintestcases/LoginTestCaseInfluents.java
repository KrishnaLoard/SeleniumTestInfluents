package com.influents.maintestcases;

import org.testng.annotations.Test;

import com.influents.UtilitiesVariable.GlobalVariables;
import com.influents.UtilitiesVariable.GlobalXPath;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTestCaseInfluents {
	@Test
	public void loginTestCase() {
		try {
			
			
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
			}

			System.out.println("Value Input is done Clicking Login now");
			// GlobalVariables.chromeDriver_Main.findElement(By.name("password")).sendKeys("password");
			Thread.sleep(1000);

			GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Login_Button)).click();

			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-menu\"]/md-menu/button")));
			Thread.sleep(1000);

			GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Logout_Button)).click();
			Thread.sleep(1000);

			if (GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"menu_container_2\"]/md-menu-content/md-menu-item[3]/button")).isDisplayed()) {
				System.out.println("LogOut menu is getting displayed");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"menu_container_2\"]/md-menu-content/md-menu-item[3]/button")).click();

			} else {
				System.out.println("Logout Button is not getting displayed Error in System");
			}
			
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.XPath_LoginUsername_Box)));
			
			System.out.println("LogOut Done Successfully Working Fine Test case passed***");
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void afterMethod() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
			System.out.println("Issues Creating Object before Class" + e);
			e.printStackTrace();
		}

	}

	@AfterClass
	public void aterClass() {
		try {
			GlobalVariables.chromeDriver_Main.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error while closing browser instance" + e);
			e.printStackTrace();
		}

	}

}
