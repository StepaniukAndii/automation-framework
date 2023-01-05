package BasePages;

import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//@Log4j
public abstract class AbstractBasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        log = LogManager.getLogger(this.getClass());
    }

    protected WebElement waitToAppear(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement waitVisibleOfElement(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected WebElement waitPresenceOfElementLocated(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public WebElement $x(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> $$x(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

}
