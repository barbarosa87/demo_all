package com.example.demo.poms;

import com.example.demo.UICommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

	private By inventoryContainerSelector=By.id("inventory_container");
	private By burgerMenuSelector=By.id("react-burger-menu-btn");
	private By burgerItemsSelector=By.xpath("//nav[@class='bm-item-list']");
	private By inventoryListSelector=By.xpath("//div[@data-test='inventory-list']");
	private By cartSelector=By.id("shopping_cart_container");
	private By cartBudge=By.xpath("//span[@data-test='shopping-cart-badge']");


	private String productSelector="//div[@data-test='inventory-item-description']//div[text()='%s']";

	private final UICommonActions uiCommonActions;
	private final WebDriver webDriver;

	public HomePage( UICommonActions uiCommonActions, WebDriver webDriver) {
		this.webDriver = webDriver;
		this.uiCommonActions = uiCommonActions;
	}

	public boolean isLoggedIn(){
		return uiCommonActions.waitAndGetElement(webDriver,inventoryContainerSelector)!=null;
	}

	public void openBurgerMenu(){
		 uiCommonActions.waitAndGetElement(webDriver,burgerMenuSelector).click();
	}

	public List<String> getBurgerMenuItems(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,burgerItemsSelector);
		List<String> itemsList=new ArrayList<>();
		elem.findElements(By.xpath(".//a")).forEach(element ->itemsList.add(element.getText()) );

		return itemsList;

	}

	public boolean isDisplayingProducts(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,inventoryListSelector);
		return elem!=null;
	}

	public void goToProduct(String product){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,By.xpath(String.format(productSelector,product)));
		elem.click();
	}

	public void goToCart(){
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,cartSelector);
		elem.click();
	}

	public String getShopingCartBudge() {
		WebElement elem=uiCommonActions.waitAndGetElement(webDriver,cartBudge);
		return elem.getText();
	}
}

