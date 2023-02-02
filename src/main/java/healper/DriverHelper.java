package healper;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverHelper {

    private static String headless;
    private static String grid;

    public static void setHeadless(String headless) {
        DriverHelper.headless = headless;
    }

    public static void setGrid(String grid) {
        DriverHelper.grid = grid;
    }

    @SneakyThrows
    public static WebDriver getGridDriver() {
        if (!grid.equals("${grid")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
            chromeOptions.addArguments("star-maximized");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments(("--disable-dev-shm-usage"));
            DesiredCapabilities capabilities = new DesiredCapabilities(chromeOptions);
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "chrome");
            capabilities.setCapability("enableVNC", false);
            capabilities.setCapability("enableVideo", false);

            return new RemoteWebDriver(
                    new URL("http://localhost:4444/"), capabilities);

        } else {
            WebDriverManager.chromedriver().setup();
            return setSize(new ChromeDriver(getOptions()));
        }
    }

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return setSize(new ChromeDriver(getOptions()));
    }

    public static WebDriver setSize(WebDriver driver) {
        if (headless.equals("true")) {
            driver.manage().window().setSize(new Dimension(1920, 1200));
        } else {
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        if (headless.equals("true")) {
            options.addArguments("--headless");
        }
        return options;
    }
}
