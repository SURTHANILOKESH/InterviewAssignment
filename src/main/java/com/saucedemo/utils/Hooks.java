package com.saucedemo.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks extends BaseClass{
	
	@BeforeSuite
	public void setupDriver() {
		setup();
	}

	@AfterSuite
	public void quitDriver() {
		tearDown();
	}

}
