package com.example.demo.poms;

import com.example.demo.UICommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckOutOverviewPage {



	private By finishSelector=By.id("finish");

	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	public CheckOutOverviewPage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}

	public void finishCheckout(){
		uiCommonActions.waitAndGetElement(webDriver,finishSelector).click();
	}

}
