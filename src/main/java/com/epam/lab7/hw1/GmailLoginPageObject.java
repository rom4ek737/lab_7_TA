package com.epam.lab7.hw1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPageObject {

    private WebDriver driver;
    private static String ps = PropertySettings.openProperyFile("webadress");

    @FindBy(css = "input#identifierId")
    private TextInput textInputLoginField;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    private TextInput passwordField;

    @FindBy(xpath = "//*[@class = 'gb_he']")
    private WebElement openGoogleApps;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    private WebElement selectGmail;

    public GmailLoginPageObject(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    public Boolean gmailLogin(String email, String password) {
        textInputLoginField.addText(email);
        textInputLoginField.submit();
        passwordField.addText(password);
        passwordField.submit();
        return true;
    }

    //@Then("^Gmail page has been opened!$")
    public void openGmail() {
        openGoogleApps.click();
        selectGmail.click();
    }
}
