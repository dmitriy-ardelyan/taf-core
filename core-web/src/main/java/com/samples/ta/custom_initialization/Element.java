package com.samples.ta.custom_initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import java.util.List;
import java.util.stream.Collectors;

public class Element implements WrapsElement, CanSearch {

    private WebElement wrappedElement;

    public Element(WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public List<Element> findElements(By by) {
        return getWrappedElement()
                .findElements(by)
                .stream()
                .map(Element::new)
                .collect(Collectors.toList());
    }

    @Override
    public Element findElement(By by) {
        return new Element(getWrappedElement().findElement(by));
    }

    @Override
    public WebElement getWrappedElement() {
        return wrappedElement;
    }
}
