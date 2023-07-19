package com.samples.ta.driver;

import com.samples.ta.custom_initialization.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor {
    private JavascriptExecutor javascriptExecutor;

    public JSExecutor(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void scrollTo(Element element) {
        javascriptExecutor
                .executeScript("arguments[0].scrollIntoViewIfNeeded();",element.getWrappedElement());
    }
}
