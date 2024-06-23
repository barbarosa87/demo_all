package com.example.demo;

import com.example.demo.configuration.Config;
import com.example.demo.poms.CheckOutFinishPage;
import com.example.demo.poms.CheckOutPage;
import com.example.demo.poms.HomePage;
import com.example.demo.poms.LoginPage;
import com.example.demo.steps.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Service
public class Validations {

	Logger logger = LoggerFactory.getLogger(Validations.class);
	@Autowired
	private Config config;

	@Autowired
	UICommonActions uiCommonActions;

	@Autowired
	private World world;

	public void validateProductPage() {
		HomePage homePage = new HomePage(uiCommonActions, world.getWebDriver());
		assertThat(homePage.isDisplayingProducts()).isTrue();
	}


	public void hasLoginError() {
		LoginPage loginPage = new LoginPage(uiCommonActions, world.getWebDriver());
		assertThat(loginPage.isLoginError()).isTrue();
	}


	public void isLoggedIn() {
		HomePage homePage = new HomePage(uiCommonActions, world.getWebDriver());
		assertThat(homePage.isLoggedIn()).isTrue();
	}

	public void validateBurgerMenu(String[] menuItemArray) {
		HomePage homePage = new HomePage(uiCommonActions, world.getWebDriver());
		homePage.openBurgerMenu();
		List<String> itemsList = homePage.getBurgerMenuItems();
		for (int i = 0; i < menuItemArray.length; i++) {
			assertThat(itemsList.get(i)).isEqualTo(menuItemArray[i]);
		}
	}

	public void validateCartIcon(String number) {
		HomePage homePage = new HomePage(uiCommonActions, world.getWebDriver());
		assertThat(homePage.getShopingCartBudge()).isEqualTo(number);
	}

	public void checkoutSuccess() {
		CheckOutFinishPage checkOutFinishPage = new CheckOutFinishPage(uiCommonActions, world.getWebDriver());
		assertThat(checkOutFinishPage.isSucessCheckout()).isEqualTo("Thank you for your order!");
	}

	public void errorAtCheckoutPage() {
		CheckOutPage checkOutPage = new CheckOutPage(uiCommonActions, world.getWebDriver());
		checkOutPage.hasError();
	}
}
