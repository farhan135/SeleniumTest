package com.farhan;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SeleniumHelper {
	public WebDriver getFireFoxWebDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.popup_maximum", 0);
		profile.setPreference("privacy.popups.showBrowserMessage", false);
		profile.setPreference("dom.webnotifications.enabled", false);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		WebDriver webDriver = new FirefoxDriver(options);
		return webDriver;
	}
	
	public void takeScreenshot(WebDriver webDriver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:/selenium/error.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void closeWebDriver(WebDriver webDriver) {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		webDriver.close();
		webDriver.quit();
	}
}
