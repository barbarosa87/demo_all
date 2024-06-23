package com.example.demo;


import com.example.demo.configuration.Config;
import com.example.demo.poms.CartPage;
import com.example.demo.poms.CheckOutOverviewPage;
import com.example.demo.poms.CheckOutPage;
import com.example.demo.poms.HomePage;
import com.example.demo.poms.LoginPage;
import com.example.demo.poms.ProductPage;
import com.example.demo.steps.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Actions {

	Logger logger = LoggerFactory.getLogger(Actions.class);
	@Autowired
	private Config config;

	@Autowired
	UICommonActions uiCommonActions;

	@Autowired
	private World world;


	public void openPage() {
		world.getWebDriver().get(config.getAppUrl());
	}


	public void loginUser(String username) {
		LoginPage page = new LoginPage(uiCommonActions, world.getWebDriver());
		page.addUsername(username);
		page.addPassword(config.getPassword());
		page.performLogin();
	}

	public void addToCart(String product) {
		HomePage page = new HomePage(uiCommonActions, world.getWebDriver());
		page.goToProduct(product);
		ProductPage productPage = new ProductPage(uiCommonActions, world.getWebDriver());
		productPage.addProductToCart();
		productPage.navigateBack();
	}

	public void goToCart() {
		HomePage page = new HomePage(uiCommonActions, world.getWebDriver());
		page.goToCart();
	}

	public void checkoutProduct(String fname, String lname, String pCode) {
		HomePage homePage = new HomePage(uiCommonActions, world.getWebDriver());
		homePage.goToCart();
		CartPage cartPage = new CartPage(uiCommonActions, world.getWebDriver());
		cartPage.goToCheckOutPage();
		CheckOutPage checkOutPage = new CheckOutPage(uiCommonActions, world.getWebDriver());
		checkOutPage.fillCheckoutForm(fname, lname, pCode);
		checkOutPage.pressContinue();
	}

	public void proccedsWithCheckoutOverview() {
		CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage(uiCommonActions, world.getWebDriver());
		checkOutOverviewPage.finishCheckout();
	}

}




