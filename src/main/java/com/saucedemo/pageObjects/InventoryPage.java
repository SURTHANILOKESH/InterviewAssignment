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

public class InventoryPage extends BaseClass{

	Logger logger = LogManager.getLogger(InventoryPage.this);
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	
	public InventoryPage() {
	PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(.,'Products')]/..")
	private WebElement productsHeader;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIcon;
	
	public void addProduct(String products) {
		if (products.contains(",")) {
			String [] productArr = products.split(",");
			for (String product : productArr) {
				WebElement addProduct = getDynamicWebElementByXpath("//div[contains(.,'%s') and contains(@class,'inventory_item_name ')]/ancestor::div[@class='inventory_item']//button", product);
				addProduct.click();
			}
		}else {
			WebElement addProduct = getDynamicWebElementByXpath("//div[contains(.,'%s') and contains(@class,'inventory_item_name ')]/ancestor::div[@class='inventory_item']//button", products);
			addProduct.click();
		}
	}
	//div[contains(.,'%s') and contains(@class,'inventory_item_name ')]/ancestor::div[@class='inventory_item']//button
	
	
	public boolean isProductHeaderDisplayed() {
		boolean isDisplayed = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(productsHeader));
			return productsHeader.isDisplayed();
		} catch (Exception e) {
			return isDisplayed;
		}
	}
	
	public void clickOnCartIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		cartIcon.click();
	}
}
