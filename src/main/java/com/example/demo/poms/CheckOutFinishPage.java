package com.example.demo.poms;

import com.example.demo.UICommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutFinishPage {


	private By succsessCheckoutSelector=By.xpath("//h2[@data-test='complete-header']");

	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	public CheckOutFinishPage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}

	public String isSucessCheckout(){
		return uiCommonActions.waitAndGetElement(webDriver,succsessCheckoutSelector).getText();
	}

}
