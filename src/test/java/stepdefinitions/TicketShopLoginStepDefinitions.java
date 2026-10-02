package stepdefinitions;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.TicketShopLoginPage;
import pages.TicketShopMainPage;


@RunWith(Cucumber.class)
@RequiredArgsConstructor
public class TicketShopLoginStepDefinitions {

    private WebDriver driver;
    TicketShopMainPage ticketShopMainPage;
    TicketShopLoginPage ticketShopLoginPage;

    @Given("I navigate to the main page {string}")
    public void iNavigateToTheMainPage(String address) {
        driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-search-engine-choice-screen"));
        driver.manage().window().maximize();
        driver.get(address);
    }

    @When("I click the login now button")
    public void iClickTheButton() {
        ticketShopMainPage = new TicketShopMainPage(driver);
        ticketShopMainPage.clickLoginNowBtn();
    }
    @And("I enter email {string} and password {string}")
    public void iEnterAValidEmailAndPassword(String email, String password) {
        ticketShopLoginPage = new TicketShopLoginPage(driver);
        ticketShopLoginPage.enterEmail(email);
        ticketShopLoginPage.enterPassword(password);
    }

    @And("I confirm the entry by clicking on the login button")
    public void iConfirmTheEntryByClickingOnTheLoginButton() {
        ticketShopLoginPage.clickLoginBtn();
    }

    @Then("The login is successful")
    public void theLoginIsSuccessful() {
        ticketShopMainPage.checkUserIsLoggedIn();
        driver.close();
    }

    @Then("The login is not successful")
    public void theLoginIsNotSuccessful() {
        ticketShopLoginPage.checkFeedbackMessage();
        driver.close();
    }
}
