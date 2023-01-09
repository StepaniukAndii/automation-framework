import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import lombok.extern.log4j.Log4j;

@Log4j
public class Retry implements IRetryAnalyzer {

    int initCount = 0;
    int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (initCount < maxRetryCount) {
            initCount++;
            Log4j.error("Test " + result.getTestName() + " failed. Start attempt " + initCount);
            return true;
        }
        return false;
    }
}

// to implement retry, write @Test(retryAnalyzer = Retry.class) before test
