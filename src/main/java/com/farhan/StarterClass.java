package com.farhan;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class StarterClass {

	public static void main(String[] args) {
		System.out.println("testing..");
		// Set gecko driver path
		System.setProperty("webdriver.gecko.driver", "C:\\DEV\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		// initialize firefox driver object to open firefox browser
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.popup_maximum", 0);
		profile.setPreference("privacy.popups.showBrowserMessage", false);
		profile.setPreference("dom.webnotifications.enabled", false);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		WebDriver webDriver = new FirefoxDriver(options);
		// Maximize the window
		webDriver.manage().window().maximize();		
		// open URL in browser
		webDriver.get("http://www.facebook.com");
		try {
			webDriver.findElement(By.id("email")).sendKeys("dawayiam_03@yahoo.com");
			webDriver.findElement(By.id("pass")).sendKeys("thearrivals3");
			webDriver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			webDriver.findElement(By.xpath("//*[contains(@title, 'Profile')]")).click();
			Thread.sleep(5000);
			webDriver.findElement(By.xpath("//*[@data-tab-key='friends']")).click();
			Thread.sleep(5000);
		} catch (Exception exception) {
			System.out.println("Exception: " + exception + "\n");
		} finally {
			takeScreenshot(webDriver);
			closeWebDriver(webDriver);
		}
	}

	private static void takeScreenshot(WebDriver webDriver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:/selenium/error.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void closeWebDriver(WebDriver webDriver) {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		webDriver.close();
		webDriver.quit();
	}

}
