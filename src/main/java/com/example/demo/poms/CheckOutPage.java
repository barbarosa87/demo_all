package com.example.demo.poms;

import com.example.demo.UICommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {



	private By fnameSelector=By.id("first-name");
	private By lnameSelector=By.id("last-name");
	private By pCodeSelector=By.id("postal-code");
	private By continueSelector=By.id("continue");
	private By errorSelector=By.xpath("//h3[@data-test='error']");

	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	public CheckOutPage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}

	public void fillCheckoutForm(String fname, String lname,String pCode) {
		uiCommonActions.waitAndGetElement(webDriver,fnameSelector).sendKeys(fname);
		uiCommonActions.waitAndGetElement(webDriver,lnameSelector).sendKeys(lname);
		uiCommonActions.waitAndGetElement(webDriver,pCodeSelector).sendKeys(pCode);
	}


	public void pressContinue() {
		uiCommonActions.waitAndGetElement(webDriver,continueSelector).click();
	}

	public boolean hasError() {
		return uiCommonActions.waitAndGetElement(webDriver,errorSelector)!=null;
	}


}


