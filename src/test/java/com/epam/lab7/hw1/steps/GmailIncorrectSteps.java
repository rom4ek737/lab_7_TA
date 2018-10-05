package com.epam.lab7.hw1.steps;

import com.epam.lab7.hw1.GmailBusinessObject;
import com.epam.lab7.hw1.GmailImportantPageObject;
import com.epam.lab7.hw1.GmailLoginPageObject;
import com.epam.lab7.hw1.PropertySettings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmailIncorrectSteps {
    private WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(GmailCorrectSteps.class);
    private static String ps = PropertySettings.openProperyFile("driverPath");

    static {
        System.setProperty("webdriver.chrome.driver", ps);
    }

    @Given("^I am a gmail site user$")
    public void newInit() throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertySettings.openProperyFile("webadress"));
    }

    @When("^I enter the incorrect Username \"([^\"]*)\" and Password \"(.*)\"$")
    public void enterUserLoginAndPassword(String username, String password) throws Throwable {
        GmailLoginPageObject gipo = new GmailLoginPageObject(driver);
        gipo.gmailLogin(username, password);
    }

    @Then("^I don't should be redirected to the home page of the gmail$")
    public void validateRelogin() {
        if (!driver.getCurrentUrl().equalsIgnoreCase("https://mail.google.com/mail/u/0/#inbox")) {
            LOGGER.info("Test passed!");
        } else {
            LOGGER.info("Test failed!");
        }
        LOGGER.info("After test method have finished!");
        driver.quit();
    }
}