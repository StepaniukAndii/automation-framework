package healper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHelper {

    private static String headless;
    private static String grid;

    public static void setHeadless(String headless) {
        DriverHelper.headless = headless;
    }

    public static void setGrid(String grid) {
        DriverHelper.grid = grid;
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
            new ChromeOptions().setHeadless(true);
        }
        return options;
    }
}
