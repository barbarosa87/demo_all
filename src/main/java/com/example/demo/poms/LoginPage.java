package com.example.demo.poms;

import com.example.demo.UICommonActions;
import com.example.demo.configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class LoginPage {


	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	private final By usernameSelector=By.id("user-name");
	private final By passwordSelector=By.id("password");
	private final By loginButtonSelector=By.id("login-button");
	private final By loginErrorSelector=By.xpath("//h3[@data-test='error']");

	public LoginPage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}

	public void addUsername(String username){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,usernameSelector);
		elem.sendKeys(username);
	}

	public void addPassword(String password){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,passwordSelector);
		elem.sendKeys(password);
	}

	public void performLogin(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,loginButtonSelector);
		elem.click();
	}

	public boolean isLoginError(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,loginErrorSelector);
		return elem!=null;
	}


}
