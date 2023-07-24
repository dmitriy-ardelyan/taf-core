package com.samples.ta.driver;

import com.samples.ta.LoggerSupplier;
import com.samples.ta.object.mapping.ObjectsMapper;

import com.samples.ta.properties.ResourceReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverConfig {

    private static Logger LOG = LoggerSupplier.getLogger();

    public static WebDriver initDriver() {
        LOG.info("Driver init process started");
        Properties propertiesFromResource = ResourceReader.getResourceAsProperties("web_driver.properties");
        WebDriverProperties properties = ObjectsMapper.map(WebDriverProperties.class, propertiesFromResource);

        LoggingPreferences logPreferences = new LoggingPreferences();
        logPreferences.enable(LogType.DRIVER, java.util.logging.Level.INFO);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability("loggingPrefs", logPreferences);

        WebDriver driver = getFactory(properties).getDriver(capabilities, properties);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(properties.getImplicitWait(),
                TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(properties.getPageLoadTimeout()
                , TimeUnit.SECONDS);

        LOG.info("Web driver configured." + capabilities.toString());

        return driver;
    }

    private static WebDriverFactory getFactory(WebDriverProperties webDriverProperties) {
        switch (webDriverProperties.getBrowser()) {
            case "chrome":
                return new ChromeDriverFactory();
            default:
                return new ChromeDriverFactory();

        }
    }
}
