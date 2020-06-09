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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class SnapCast_CardView_NewCard {
	@Test
	public void creatingCard_NewCard() {

		try {
			GlobalVariables.chromeDriver_Main.manage().getCookies().clear();
			GlobalVariables.chromeDriver_Main.get(GlobalXPath.login_Url);
			GlobalVariables.chromeDriver_Main.manage().window().maximize();
			// GlobalVariables.chromeDriver_Main.executeScript("document.body.style.zoom='90%'","");
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

			// Login button Click
			GlobalVariables.chromeDriver_Main.findElement(By.xpath(GlobalXPath.XPath_Login_Button)).click();

			// Checking for Successful Login wait until that.
			driverWait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user-menu\"]/md-menu/button")));
			
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(GlobalXPath.XPath_Logout_Button)));
			
			Thread.sleep(5000);
			GlobalVariables.chromeDriver_Main
					.findElement(By.xpath("//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[1]/div/div")).click();

			// wait till snapcast option is visible in list 2
			driverWait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[2]/div/div")));

			// wait till snapcast
			driverWait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[2]/div/div")));

			Thread.sleep(1000);

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

			Thread.sleep(1000);

			GlobalVariables.chromeDriver_Main
					.findElement(By.xpath("//*[@id=\"vertical-navigation\"]/ms-navigation/ul/li[2]/ul/li[3]/div/a"))
					.click();

			// Wait till new button is getting visible
			driverWait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"todo\"]/md-sidenav/md-content/div[1]/a")));

			// Click on the new Card tab.
			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"todo\"]/md-sidenav/md-content/div[1]/a"))
					.click();
			

			Thread.sleep(2000);

			// Wait till the new card menu is visible
			driverWait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"board-selector\"]/div[1]/div[1]")));
			
			// Click the story card
			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"board-selector\"]/div[1]/div[1]"))
					.click();
			
			
			// Wait till the card details getting visible
			driverWait.until(ExpectedConditions.elementToBeClickable(By.id("card-title")));

			// Enter Card title
			GlobalVariables.chromeDriver_Main.findElement(By.id("card-title"))
					.sendKeys("Card Title of the Automation Card Everyone");

			// Add card description
			GlobalVariables.chromeDriver_Main.findElement(By.id("card-desc"))
					.sendKeys("Card description by the team QA please ingore this test since its automation"
							+ "test case created by the automation software Sending to everyone into the audience Team QA");

			Thread.sleep(1000);

			GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"board\"]/div[2]/md-card[1]/div")).click();
			Thread.sleep(1000);

			Actions actions2 = new Actions(GlobalVariables.chromeDriver_Main);

			actions2.sendKeys(Keys.CONTROL, Keys.END).perform();

			Thread.sleep(2000);

			// Upload file on the Card click on the images button
			GlobalVariables.chromeDriver_Main
					.findElement(
							By.xpath("//*[contains(@id,'tab-content-')]/div/md-content/form/md-input-container[3]/button/span"))
					.click();
			// Wait until image inside dialogbox is visoble
			driverWait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'dialogContent_')]")));
			Thread.sleep(2000);

			// wait till image inside box is avaiable
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[contains(@id,'dialogContent_')]/md-grid-list/md-grid-tile[2]/figure/img")));

			GlobalVariables.chromeDriver_Main
					.findElement(
							By.xpath("//*[contains(@id,'dialogContent_')]/md-grid-list/md-grid-tile[2]/figure/img"))
					.click();
			
			
			
			if (GlobalVariables.chromeDriver_Main
					.findElement(By.xpath("/html/body/div[6]/md-dialog/md-dialog-actions/div[2]/button")).isEnabled()) {

				GlobalVariables.chromeDriver_Main
						.findElement(By.xpath("/html/body/div[6]/md-dialog/md-dialog-actions/div[2]/button")).click();
			} else {
				// wait until the button gets enable
				driverWait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("/html/body/div[6]/md-dialog/md-dialog-actions/div[2]/button")));
				System.out.println("There is Error into the code ok button is not getting Visible or enabled.");
			}
			
			//GlobalVariables.chromeDriver_Main.findElement(By.xpath("//*[@id=\"board\"]/div[2]/md-card[3]/div/div[1]")).click();
			
			Thread.sleep(2000);
			Actions actions3 = new Actions(GlobalVariables.chromeDriver_Main);

			driverWait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"cards\"]/div/div[1]/div/div[2]/button[2]")));

			GlobalVariables.chromeDriver_Main
					.findElement(By.xpath("//*[@id=\"cards\"]/div/div[1]/div/div[2]/button[2]")).click();

			System.out.println("Card is Pushed");

			Thread.sleep(5000);

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
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {

		try {
			GlobalVariables.chromeDriver_Main.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
