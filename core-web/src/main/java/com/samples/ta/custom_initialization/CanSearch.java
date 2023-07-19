package com.samples.ta.custom_initialization;

import org.openqa.selenium.By;

import java.util.List;

public interface CanSearch {
    List<Element> findElements(By by);

    Element findElement(By by);
}
