package com.epam.lab7.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailBusinessObject {

    private WebDriver driver;
    private GmailLoginPageObject gmailLoginPageObject;
    private GmailImportantPageObject gmailImportantPageObject;
    private Boolean aBoolean = false;

    private static final Logger LOGGER = LogManager.getLogger(GmailBusinessObject.class);

    public GmailBusinessObject(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    public Boolean openGmailAccount(String email, String password) {
        LOGGER.info("We are started to open gmail page");
        gmailLoginPageObject = new GmailLoginPageObject(driver);
        gmailLoginPageObject.gmailLogin(email, password);
        LOGGER.info("We typed the login/password!");
        gmailLoginPageObject.openGmail();
        LOGGER.info("we opened gmail account!!!");
        aBoolean = true;
        return aBoolean;
    }

    public int selectAndDeleteImportantMessages() throws InterruptedException{
        gmailImportantPageObject = new GmailImportantPageObject(driver);
        LOGGER.info("We are starting to check the important messages");
        int number = gmailImportantPageObject.checkThreeMessages();
        LOGGER.info("Messages are checked!");
        gmailImportantPageObject.openImportantFolder();
        LOGGER.info("Folder 'Important' was open!");
        gmailImportantPageObject.deleteLetters();
        LOGGER.info("The letters have been deleted!");
        return number;
    }
}
