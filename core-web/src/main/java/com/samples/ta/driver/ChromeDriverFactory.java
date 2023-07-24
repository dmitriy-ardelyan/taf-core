package com.samples.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class ChromeDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(DesiredCapabilities capabilities, WebDriverProperties properties) {
        DesiredCapabilities capabilitiesChrome = new DesiredCapabilities("chrome", "", Platform.ANY);
        capabilitiesChrome.merge(capabilities);

        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromeSettings = new HashMap<>();
        chromeSettings.put("profile.default_content_settings.popups", 0);

        chromeOptions.addArguments("always-authorize-plugins");
        chromeOptions.addArguments("allow-running-insecure-content");
        chromeOptions.addArguments("ignore-certificate-errors");

        chromeOptions.setExperimentalOption("prefs", chromeSettings);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.merge(capabilitiesChrome);

        String chromeDriverVersion = properties.getDriverVersion();
        if (chromeDriverVersion.isEmpty()){
            WebDriverManager.chromedriver().setup();
        } else {
            WebDriverManager.chromedriver().driverVersion(chromeDriverVersion).setup();
        }
        ChromeDriverService driverService = ChromeDriverService.createDefaultService();
        WebDriver driver = new ChromeDriver(driverService, chromeOptions);

        return driver;
    }
}
