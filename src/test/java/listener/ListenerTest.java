
package listener;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

@Log4j
public class ListenerTest implements ITestListener {

    WebDriverManager driver = new ChromeDriverManager();

    @Override
    public void onFinish(ITestContext Result) {

        log.info("  The name of the testcase  is On Finish :-" + Result.getName() + "             ");
        log.info("=========================================");
    }


    @Override
    public void onStart(ITestContext Result) {

        log.info("The name of the testcase on Start" + Result.getName() + "            ");
        log.info("===============================================================");
    }


    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result) {
        log.info("The name of the testcase failed is :" + Result.getName());
        log.info("===============================================================");

    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result) {
        System.out.println("The name of the testcase Skipped is :" + Result.getName());
        log.info("===============================================================");
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result) {
        System.out.println(Result.getName() + " test case started");
        log.info("===============================================================");
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("The name of the testcase passed is :" + Result.getName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); // https://habr.com/ru/company/sberbank/blog/358836/
    }
}
