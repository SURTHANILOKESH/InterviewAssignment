package com.saucedemo.pageObjects;

import org.openqa.selenium.WebElement;

import com.saucedemo.utils.BaseClass;

public class CheckoutPage extends BaseClass{
	
	public boolean isProductsDisplayed(String products) {
			boolean isDisplayed = false;
			try {
			if (products.contains(",")) {
				String [] productArr = products.split(",");
				for (String product : productArr) {
					WebElement viewProduct = getDynamicWebElementByXpath("//div[contains(.,'%s') and contains(@class,'inventory_item_name')]", product);
					if(viewProduct.isDisplayed()) {
						isDisplayed = true;
					}else {
						isDisplayed = false;
						break;
					}
				}
			}else {
				WebElement product = getDynamicWebElementByXpath("//div[contains(.,'%s') and contains(@class,'inventory_item_name')]", products);
				isDisplayed = product.isDisplayed();
			}}
			catch(Exception e) {
				System.out.println(e);
				isDisplayed = false;
			}
			return isDisplayed;
		}
}

