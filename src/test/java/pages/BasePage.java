package pages;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@Accessors(fluent = true)
@Getter
@Setter
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected WebElement waitForElement(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElement(WebElement element, By locator) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void fillInputField(WebElement element, String value) {
        WebElement inputField = waitForElement(element);
        assertTrue(inputField.isDisplayed());
        inputField.clear();
        inputField.sendKeys(value);
    }

    protected void clickButton(WebElement button, By locator) {
        WebElement element = waitForElement(button, locator);
        assertTrue(element.isDisplayed());
        element.click();
    }

    protected void assertElementIsDisplayed(WebElement element) {
        assertTrue(waitForElement(element).isDisplayed());
    }
}
