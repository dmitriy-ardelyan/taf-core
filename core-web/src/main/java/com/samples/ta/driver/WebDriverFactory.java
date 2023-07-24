package com.samples.ta.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface WebDriverFactory {
    WebDriver getDriver(DesiredCapabilities capabilities, WebDriverProperties properties);
}
