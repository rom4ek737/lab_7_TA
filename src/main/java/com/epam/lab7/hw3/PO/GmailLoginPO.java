package com.epam.lab7.hw3.PO;

import com.epam.lab7.hw3.CustomFieldDecorator;
import com.epam.lab7.hw3.TextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPO {

    private WebDriver driver;

    @FindBy(css = "input#identifierId")
    private TextInput textInputLoginField;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    private TextInput passwordField;

    @FindBy(xpath = "//*[@class = 'gb_he']")
    private WebElement openGoogleApps;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    private WebElement selectGmail;

    public GmailLoginPO(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void gmailLogin(String email, String password) {
        textInputLoginField.addText(email);
        textInputLoginField.submit();
        passwordField.addText(password);
        passwordField.submit();
    }

    public void openGmail() {
        openGoogleApps.click();
        selectGmail.click();
    }
}
