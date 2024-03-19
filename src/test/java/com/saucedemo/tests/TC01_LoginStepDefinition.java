package com.saucedemo.tests;

import org.testng.Assert;

import com.saucedemo.pageObjects.CheckoutPage;
import com.saucedemo.pageObjects.InventoryPage;
import com.saucedemo.pageObjects.LoginPage;
import com.saucedemo.utils.BaseClass;
import com.saucedemo.utils.ReadConfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_LoginStepDefinition extends BaseClass{
	LoginPage loginPage = new LoginPage();
	InventoryPage inventoryPage = new InventoryPage();

	@Given("^Navigate to saucedemo application$")
	public void navigateToApplication() {
		getDriver().get(ReadConfig.getApplicationURL());
	}
	
	@Then("^Verify user lands on home page$")
	public void verifyHomePage() {
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(),"Login button not displayed");
	}
	
	@When("^User enter the (.+) and (.+)$")
	public void enterLoginCredentials(String userName, String password) {
		loginPage.setUserCredentials(userName, password);
	}
	
	@And("^Click on login button$")
	public void clickLogin() {
		loginPage.clickOnLogin();
	}
	
	@Then("^Verify user lands on the inventory page$")
	public void verifyValidLogin() {
		Assert.assertTrue(inventoryPage.getUrl().contains("inventory"));
		Assert.assertTrue(inventoryPage.isProductHeaderDisplayed(), "products header not displayed");
	}
	
	@Then("^Verify user does not lands on the inventory page$")
	public void verifyInvalidLogin() {
		Assert.assertFalse(inventoryPage.getUrl().contains("inventory"));
		Assert.assertFalse(inventoryPage.isProductHeaderDisplayed(), "products header not displayed");
	}
	
	
}
