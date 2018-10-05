package com.epam.lab7.hw1.steps;

import com.epam.lab7.hw1.GmailBusinessObject;
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

public class GmailCorrectSteps {
    private WebDriver driver;
    private String str;

    private static final Logger LOGGER = LogManager.getLogger(GmailCorrectSteps.class);
    private static String ps = PropertySettings.openProperyFile("driverPath");

    static {
        System.setProperty("webdriver.chrome.driver", ps);
    }

    @Given("^I am a gmail email site user$")
    public void init() throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LOGGER.info("Test method");
        driver.get(PropertySettings.openProperyFile("webadress"));
    }

    @When("^I enter the correct Username \"([^\"]*)\" and Password \"(.*)\"$")
    public void gmailAuthorization(String username, String password) throws InterruptedException {
        GmailBusinessObject gim = new GmailBusinessObject(driver);
        gim.openGmailAccount(username, password);
        LOGGER.info("The test method was completed scientifically");
    }

    @Then("^I should be redirected to the home page of the gmail$")
    public void closeDriver() {
        LOGGER.info("After test method have finished!");
        driver.quit();
    }
}
