package com.epam.lab7.hw3;

import com.epam.lab7.hw3.BO.GmaiLoginBO;
import com.epam.lab7.hw3.BO.SelectAndDeleteMessagesBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@Listeners(com.epam.lab7.hw3.MyListener.class)

public class GmaiLoginBOFinalTest {

    private static final Logger LOGGER = LogManager.getLogger(GmaiLoginBOFinalTest.class);
    private static String ps = PropertySettings.openPropertyFile("driverPath");

    static {
        System.setProperty("webdriver.chrome.driver", ps);
    }

    @BeforeClass
    public void setupClassName(ITestContext context) {
        LOGGER.info("Before class method");
    }

    @BeforeMethod
    public void init() throws IOException {
        LOGGER.info("Before test method");
        WebDriver driver = DriverPool.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertySettings.openPropertyFile("webadress"));
    }

    @Test(dataProvider = "provider-data", dataProviderClass = DataproviderClass.class)
    public void openGmailAndDeleteImportantMessages(String email, String password) {
        LOGGER.info("Test method");
        WebDriver driver = DriverPool.getInstance().getDriver();
        GmaiLoginBO gim = new GmaiLoginBO(driver);
        assertTrue(gim.openGmailAccount(email, password));
        SelectAndDeleteMessagesBO gdbo = new SelectAndDeleteMessagesBO(driver);
        int number = gdbo.selectAndDeleteImportantMessages();
        assertNotNull(number);
        LOGGER.info("The test method was completed scientifically");
    }

    @AfterMethod
    public void closeDriver() {
        LOGGER.info("After test method have finished!");
        DriverPool.getInstance().closeDriver();
    }
}