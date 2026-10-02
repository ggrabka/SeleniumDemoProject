package pages;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Accessors(fluent = true)
@Getter
public class TicketShopLoginPage extends BasePage{

    @FindBy(id = "kc-login")
    private WebElement btnLogin;

    @FindBy(id = "username")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(className = "kc-feedback-text")
    private WebElement feedbackMessage;

    public TicketShopLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(String email)
    {
        fillInputField(inputEmail, email);
    }
    public void enterPassword(String password)
    {
        assertTrue(inputPassword.isDisplayed());
        fillInputField(inputPassword, password);
    }
    public void clickLoginBtn()
    {
        WebElement loginButton = waitForElement(btnLogin);
        assertTrue(loginButton.isDisplayed());
        loginButton.click();
    }

    public void checkFeedbackMessage()
    {
        WebElement feedback = waitForElement(feedbackMessage);
        assertElementIsDisplayed(feedbackMessage);
        assertEquals("Ungültige E-Mail Adresse oder falsches Passwort. Bitte geben Sie die richtigen Daten ein.", feedback.getText());
    }
}
