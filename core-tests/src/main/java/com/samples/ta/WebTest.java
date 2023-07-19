package com.samples.ta;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;

public class WebTest extends BaseTest {
    private WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void finishWebTest() {
        driver.quit();
    }

    public void startWebTest(Method method) {

    }

    protected WebDriver getDriver() {
        return driver;
    }
}
