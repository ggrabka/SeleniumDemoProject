package pages;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

@Accessors(fluent = true)
@Getter
@Setter
public class TicketShopMainPage extends BasePage{

    @FindBy(xpath = "//button[@data-unique-id='loginBoxButtonLogin']")
    private WebElement btnLoginNow;

    @FindBy(xpath = "//button[@data-unique-id='loginBoxButtonRegister']")
    private WebElement btnCreateAccount;

    @FindBy(xpath = "//button[@data-unique-id='headerAccountButton']")
    private WebElement btnHeaderAccount;

    @FindBy(xpath = "//button[@data-unique-id='headerShoppingCartButton']")
    private WebElement btnHeaderShoppingCart;

    @FindBy(xpath = "//button[@data-unique-id='headerTicketsButton']")
    private WebElement btnHeaderTickets;

    @FindBy(xpath = "//button[@data-unique-id='userBoxButtonUserAccount']")
    private WebElement btnUserAccount;

    @FindBy(xpath = "//button[@data-unique-id='userBoxButtonLogout']")
    private WebElement btnUserLogoutBtn;

    public TicketShopMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickLoginNowBtn()
    {
        clickButton(btnLoginNow, By.xpath("//button[@data-unique-id='loginBoxButtonLogin']"));
    }

    public void checkUserIsLoggedIn()
    {
        WebElement headerAccountButton = waitForElement(btnHeaderAccount, By.xpath("//button[@data-unique-id='headerAccountButton']"));
        assertElementIsDisplayed(btnHeaderAccount);
    }
}
