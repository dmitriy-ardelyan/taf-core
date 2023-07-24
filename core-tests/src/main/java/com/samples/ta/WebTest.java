package com.samples.ta;

import com.samples.ta.driver.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class WebTest extends BaseTest {
    private WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void finishWebTest() {
        driver.quit();
    }

    @BeforeMethod
    public void startWebTest(Method method) {
        driver = WebDriverConfig.initDriver();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
