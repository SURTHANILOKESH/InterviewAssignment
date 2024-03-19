package com.saucedemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class ReadConfig {

	public static Properties prop;
	public static String browser;

	public ReadConfig() {
		File src = new File("./config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	@BeforeSuite
	@Parameters("Browser")
	public static void getBrowserName(String browserName) {
		browser = browserName;        
	}

	public String getBrowser() {
		if(browser==null) {
			browser = "chrome";
		}
		return browser;
	}
	
	public static String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public static String getUserName() {
		String userName = prop.getProperty("userName");
		return userName;
	}
	
	public static String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	
}
