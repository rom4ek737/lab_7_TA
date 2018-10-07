package com.epam.lab7.hw2.PO;

import com.epam.lab7.hw2.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailDeleteMessagesPO {
    private WebDriver driver;

    public GmailDeleteMessagesPO(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div[1]/div/div/div[1]/div/div[1]/span")
    private WebElement selectForDelete;

    @FindBy(xpath = "//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")
    private WebElement delete;


    public boolean deleteLetters() {
        selectForDelete.click();
        delete.click();
        return selectForDelete.isEnabled();
    }
}
