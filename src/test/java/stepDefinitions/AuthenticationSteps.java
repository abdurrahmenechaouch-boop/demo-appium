package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.HomePage;

public class AuthenticationSteps {


    LoginPage authPage = new LoginPage(Hooks.driver);
    HomePage homePage = new HomePage(Hooks.driver);


    @Given("I am on the login page")
    public void openLogin() {
        assert authPage.isLoginPageDisplayed(): "Login page not displayed";
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        authPage.login(username, password);
    }

    @Then("the home page is displayed")
    public void verifyHomePage() {
       assert homePage.isHomePageDisplayed():"Login page not displayed";  }
}
