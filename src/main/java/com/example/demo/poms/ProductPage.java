package com.example.demo.poms;

import com.example.demo.UICommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {


	private By addToCartSelector=By.id("add-to-cart");
	private By backButton=By.id("back-to-products");



	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	public ProductPage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}

	public void addProductToCart(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,addToCartSelector);
		elem.click();
	}

	public void navigateBack(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,backButton);
		elem.click();
	}
}
