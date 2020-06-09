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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SnapCastToEveryone_PushNotification {
	@Test
	public void snapCast_PushToeveryone() {
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

			// Login button Click
			GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Login_Button)).click();

			// Checking for Successful Login wait until that.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.XPath_Logout_Button)));

			// wait till snapcast
			driverWait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[2]/div/div")));

			// Check if snapcast page menu is visible and if not it will click to admin
			// button to load it.
			if (GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Snapcastpage)).isDisplayed()) {

				System.out.println("SnapCast page is already Visible no need for clicking admin right now--");

			} else {

				GlobalVariables.chromeDriver_Main
						.findElement(By.xpath("//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[2]/div/div"))
						.click();
				Thread.sleep(1000);

			}

			// waiting till Snapcast page menu loads
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.XPath_Snapcastpage)));

			GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Snapcastpage)).click();

			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.XPath_Logout_Button)));

			// Wait till Snapcat button is enabled.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.Xpath_Snapcast_castButton)));

			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"card-title\"]")).click();
			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"card-title\"]"))
					.sendKeys("Team QA Testing Snap to Everyone");

			Thread.sleep(1000);

			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"card-desc\"]")).clear();
			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"card-desc\"]")).sendKeys(
					"Team QA Testing Snap to Everyone This snap is system Generated and Automation test case and wil go to everyone So please ignore the test");

			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"post-box\"]/footer/div[2]/button/span"))
					.click();

			Thread.sleep(5000);

			GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Logout_Button)).click();
			Thread.sleep(1000);
			
			driverWait.until(ExpectedConditions.elementToBeClickable(GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"menu_container_2\"]/md-menu-content/md-menu-item[3]/button"))));
			
			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"menu_container_2\"]/md-menu-content/md-menu-item[3]/button")).click();
			
			/*if (GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_logout_div)).isDisplayed()) {
				System.out.println("LogOut menu is getting displayed");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_logout_div_logout)).click();

			} else {
				System.err.println("Logout Button is not getting displayed Error in System");
			}*/

			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.XPath_LoginUsername_Box)));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Occured in Simple Snap Test Case " + this.getClass());
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error into the beforemethod of test" + this.getClass());
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error into the beforemethod of test" + this.getClass());
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

}
