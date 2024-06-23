package com.example.demo;

import com.example.demo.configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;


@Component
public class UICommonActions {

	@Autowired
	private Config config;

	public WebElement waitAndGetElement(WebDriver driver, By by, int timeout) {
		WebElement elem = null;
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			elem = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			return null;
		}

		return elem;
	}

	public WebElement waitAndGetElement(WebDriver driver, By by) {
		WebElement elem = null;
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(config.getWaittimeoutSeconds()));
			elem = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			return null;
		}

		return elem;
	}

	public List<WebElement> waitAndGetElements(WebDriver driver, By by, int timeout) {
		List<WebElement> elem = null;
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			elem = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return elem;
	}

	public boolean retryingFindClick(WebDriver driver, By locator, int attempts) {
		boolean result = false;
		while (attempts < 5) {
			try {
				driver.findElement(locator).click();
				result = true;
				break;
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.getMessage());
			}
			attempts++;
		}
		return result;
	}

	public boolean retryingFindElementFromElement(WebDriver driver, By locator, int attempts) {
		boolean result = false;

		while (attempts < 5) {
			try {
				driver.findElement(locator);
				result = true;
				break;
			} catch (StaleElementReferenceException ex) {
				System.out.println(ex.getMessage());
			}
			attempts++;
		}
		return result;
	}


}
