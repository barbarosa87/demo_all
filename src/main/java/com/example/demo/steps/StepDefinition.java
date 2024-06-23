package com.example.demo.steps;


import ch.qos.logback.core.Context;
import com.example.demo.Actions;
import com.example.demo.TestContext;
import com.example.demo.Validations;
import com.example.demo.configuration.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = { TestContext.class })
public class StepDefinition {

	@Autowired
	Actions actions;

	@Autowired
	private World world;

	@Autowired
	private Config config;
	@Autowired
	private Validations validations;

	@Given("User {string} logins")
	public void userLogins(String username) {
		actions.loginUser(username);
	}

	@Given("User opens the webpage")
	public void userOpenPage() {
		actions.openPage();
	}


	@Before(order = 1)
	public void createDriver() {
		world.createDriver(config.getWaittimeoutSeconds());
	}

	@After(order = 1)
	public void closeBrowser() {
		world.getWebDriver().quit();
	}


	@Then("User receives error")
	public void userReceivesError() {
		validations.hasLoginError();
	}

	@Then("User is logged in")
	public void userIsLoggedIn() {
		validations.isLoggedIn();
	}

	@Then("User checks burger menu items order {string}")
	public void userChecksBurgerMenuItemsOrder(String menuItems) {
		String[] menuItemArray = menuItems.split(",");
		validations.validateBurgerMenu(menuItemArray);
	}

	@Then("Verifies product page is displayed correctly")
	public void verifiesProductPageIsDisplayedCorrectly() {
		validations.validateProductPage();
	}

	@Then("User adds {string} to cart")
	public void userAddsToCart(String product) {
		actions.addToCart(product);
	}

	@And("User goes to cart")
	public void userGoesToCart() {
		actions.goToCart();

	}


	@And("cart icon has the number {string}")
	public void cartIconHasTheNumber(String number) {
		validations.validateCartIcon(number);
	}

	@And("Checkout completes successfully")
	public void checkoutCompletesSuccessfully() {
		validations.checkoutSuccess();
	}

	@Then("User checkouts product with fname {string} lname {string} pcode {string}")
	public void userCheckoutsProductWithFnameLnamePcode(String fname, String lname, String pCode) {
		actions.checkoutProduct(fname, lname, pCode);
	}

	@And("Checkout has an error at information provide page")
	public void checkoutHasAnErrorAtInvormationProvidePage() {
		validations.errorAtCheckoutPage();
	}

	@And("User procceeds with checkout overview")
	public void userProcceedsWithCheckoutOverview() {
		actions.proccedsWithCheckoutOverview();
	}
}
