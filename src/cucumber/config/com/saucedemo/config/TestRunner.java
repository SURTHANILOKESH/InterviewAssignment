package com.saucedemo.config;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(plugin = {
		"pretty",														
		"html:test-out/cucumber-reports/cucumber-html-report.html", 
		"json:test-out/cucumber-reports/cucumber.json",
		"rerun:test-out/cucumber-reports/re-run.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
features = {
		"src/cucumber/features"
		},
glue = {
		"com.saucedemo.tests"
		}, 
tags = "@ALL" , dryRun = false, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests{
	
}
