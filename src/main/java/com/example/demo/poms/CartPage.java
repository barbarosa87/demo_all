package com.example.demo.poms;

import com.example.demo.UICommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private By checkOutSelector= By.id("checkout");

	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	public CartPage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}


	public void goToCheckOutPage(){
		uiCommonActions.waitAndGetElement(webDriver,checkOutSelector).click();
	}
}
