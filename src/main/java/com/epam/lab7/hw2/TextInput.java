package com.epam.lab7.hw2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextInput extends Element {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void addText(String s) {
        webElement.sendKeys(s);
    }

    public void submit() {
        webElement.sendKeys(Keys.ENTER);
    }
}
