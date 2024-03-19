package com.saucedemo.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.utils.BaseClass;

public class LoginPage extends BaseClass{

	Logger logger = LogManager.getLogger(LoginPage.this);
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	
	public LoginPage() {
	PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement userNameInput;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginButton;

	public void setUserCredentials(String userName, String password) {
		wait.until(ExpectedConditions.visibilityOf(userNameInput));
		userNameInput.sendKeys(userName);
		logger.info("Entered user name.");
		wait.until(ExpectedConditions.visibilityOf(passwordInput));
		passwordInput.sendKeys(password);
		logger.info("Entered password.");
	}
	
	public void clickOnLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		logger.info("Clicked on login button");
	}
	
	public boolean isLoginButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		return loginButton.isDisplayed();
	}
}
