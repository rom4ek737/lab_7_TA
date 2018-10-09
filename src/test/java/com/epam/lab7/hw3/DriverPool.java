package com.epam.lab7.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPool {

    private DriverPool() {

    }

    private static DriverPool driverPool = new DriverPool();

    public static DriverPool getInstance() {
        return driverPool;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return new ChromeDriver(); // can be replaced with other browser drivers
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}