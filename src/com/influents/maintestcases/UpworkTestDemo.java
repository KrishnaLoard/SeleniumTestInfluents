package com.influents.maintestcases;

import org.testng.annotations.Test;

import com.influents.UtilitiesVariable.GlobalVariables;
import com.influents.UtilitiesVariable.GlobalXPath;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class UpworkTestDemo {
	@Test
	public void upworktestde() {
		try {
			FileReader fileReader = new FileReader("config/selenium.properties");
			Properties properties = new Properties();
			properties.load(fileReader);
			
			GlobalVariables.chromeDriver_Main.get("https://commerceos.staging.devpayever.com/");
			GlobalVariables.chromeDriver_Main.manage().window().maximize();
			GlobalVariables.chromeDriver_Main.manage().getCookies().clear();
			Thread.sleep(1000);
			WebDriverWait driverWait = new WebDriverWait(GlobalVariables.chromeDriver_Main, 40);
			driverWait.until(ExpectedConditions.elementToBeClickable(By.id("mat-input-2")));
			//LoadtheURL
			if (GlobalVariables.chromeDriver_Main.findElement(By.id("mat-input-2")).isEnabled()) {
				System.out.println("Element is Visible");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.id("mat-input-2")).sendKeys("aqa@payever.org");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.id("mat-input-3")).sendKeys("Aqacool123!");
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"os-app-main\"]/entry-layout-wrapper/entry-layout/div[2]/pe-info-box/div/mat-card/mat-card-content/div/div/login-layout/entry-login/div/form/button/span")).click();
				
				//waiting apps to be clickable
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/platform-header-component/pe-platform-header/pe-navbar/mat-toolbar/div[1]/button[2]/span/span")));
				
				
				Thread.sleep(1000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/platform-header-component/pe-platform-header/pe-navbar/mat-toolbar/div[1]/button[2]/span/span")).click();
				
				Thread.sleep(2000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/div[2]/span/business-layout/apps-layout/div/div/app-card/div/mat-card/div[1]/business-applications/div[7]/div[1]/div")).click();
				
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/platform-header-component/pe-platform-header/pe-navbar/mat-toolbar/div[1]/button[3]/span/span")));
				
				Thread.sleep(1000);
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/platform-header-component/pe-platform-header/pe-navbar/mat-toolbar/div[1]/button[3]/span/span")).click();
				
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/div[2]/div/app-builder/pe-builder-themes-list/div[2]/pe-builder-themes-list-user/div/pe-builder-theme-plus/mat-card/mat-card-content")));
				
				Thread.sleep(2000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"os-app-main\"]/os-commerce-root/div[2]/div/app-builder/pe-builder-themes-list/div[2]/pe-builder-themes-list-user/div/pe-builder-theme-plus/mat-card/mat-card-content")).click();
				
				Thread.sleep(6000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"menus\"]/pe-builder-navbar-top/mat-toolbar/mat-toolbar-row/pe-builder-navbar-top-button[4]/button/span")).click();
				
				Thread.sleep(5000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"menus\"]/pe-builder-navbar-top/mat-toolbar/mat-toolbar-row/pe-builder-navbar-top-button[4]/button/span")).click();
				
				
				Thread.sleep(2000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"content\"]/div[2]/pe-editor-text-decorator/pe-text-editor/div")).click();
				
				Thread.sleep(1000);
				
				GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"content\"]/div[2]/pe-editor-text-decorator/pe-text-editor/div")).sendKeys("This test is completed");
				
				Thread.sleep(1000);
				
			}
			
			
			
			
			
			
			
			System.out.println("Value Input is done Clicking Login now");
			// GlobalVariables.chromeDriver_Main.findElement(By.name("password")).sendKeys("password");
			Thread.sleep(1000);

			// Login button Click
			//GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Login_Button)).click();
		}catch (Exception e) {
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

}
