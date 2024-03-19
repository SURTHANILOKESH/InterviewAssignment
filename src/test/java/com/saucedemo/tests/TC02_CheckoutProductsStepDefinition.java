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

public class TC02_CheckoutProductsStepDefinition extends BaseClass{
	InventoryPage inventoryPage = new InventoryPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	
	@And("^Add the products (.+) to the cart$")
	public void addProduct(String products) {
		inventoryPage.addProduct(products);
	}
	
	@When("^user click on cart icon$")
	public void clickOnCart() {
		inventoryPage.clickOnCartIcon();
	}
	@Then ("^verify user should be able to view products (.+) displayed$")
	public void verifyProductsDisplayed(String products) {
		Assert.assertTrue(checkoutPage.getUrl().contains("cart"));
		Assert.assertTrue(checkoutPage.isProductsDisplayed(products), "products not displayed");
	}
}
