package com.farhan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StarterClass {

	public static void main(String[] args) {
		// Set gecko driver path
		System.setProperty("webdriver.gecko.driver", "C:\\DEV\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		// initialize firefox driver object to open firefox browser
		SeleniumHelper seleniumHelper = new SeleniumHelper();
		WebDriver webDriver = seleniumHelper.getFireFoxWebDriver();
		// Maximize the window
		webDriver.manage().window().maximize();		
		// open URL in browser
		webDriver.get("http://www.facebook.com");
		try {
			webDriver.findElement(By.id("email")).sendKeys("email");
			webDriver.findElement(By.id("pass")).sendKeys("pass");
			webDriver.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
			webDriver.findElement(By.xpath("//*[contains(@title, 'Profile')]")).click();
			Thread.sleep(5000);
			webDriver.findElement(By.xpath("//*[@data-tab-key='friends']")).click();
			Thread.sleep(5000);
		} catch (Exception exception) {
			System.out.println("Exception: " + exception + "\n");
		} finally {
			seleniumHelper.takeScreenshot(webDriver);
			seleniumHelper.closeWebDriver(webDriver);
		}
	}

}
