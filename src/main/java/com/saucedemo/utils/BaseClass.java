package com.saucedemo.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BaseClass {

	public static ReadConfig readConfig = new ReadConfig();
	public static final Logger logger = LogManager.getLogger();
	public static WebDriver driver = null;

	
	public static WebDriver setup() {
		if (driver == null) {
			String browser = readConfig.getBrowser();
			if (browser.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				driver = new ChromeDriver(options);
				logger.info("Chrome driver initialized");
			} else if (browser.equals("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("start-maximized");
				driver = new FirefoxDriver(options);
				logger.info("FireFox driver initialized");
			} else if (browser.equals("edge")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("start-maximized");
				driver = new EdgeDriver(options);
				logger.info("Edge driver initialized");
			}

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void tearDown() {
		driver.quit();
		logger.info("Driver closed.");
	}
	
	public String getUrl() {
		String url = getDriver().getCurrentUrl();
		logger.info("Captured URL: "+url);
		return url;
	}

	public WebElement getDynamicWebElementByXpath(String xpath, Object... dynamicValues) {
		String newGenratedString = String.format(xpath, dynamicValues);
		WebElement element = getDriver().findElement(By.xpath(newGenratedString));
		return element;
	}
}
