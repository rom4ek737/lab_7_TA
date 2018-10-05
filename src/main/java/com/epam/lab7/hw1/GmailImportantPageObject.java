package com.epam.lab7.hw1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailImportantPageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    public GmailImportantPageObject(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindAll({
            @FindBy(css = "div.pG")
    })
    private List<WebElement> messages;

    @FindBy(css = "#aso_search_form_anchor > div > input")
    private WebElement searchField;

    @FindBy(css = ".T-Jo.J-J5-Ji.T-Jo-auq.T-Jo-iAfbIe")
    private WebElement selectThreeLetters;

    @FindBy(css = "#\\3a 9z > span > span:nth-child(1) > span:nth-child(2)")
    private WebElement importantLetters;

    //@FindAll({
    @FindBy(xpath = "//*[@id=\":8p\"]/div[1]/span")
    //})
    private WebElement selectForDelete;

    @FindBy(xpath = "//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")
    private WebElement delete;

    public int checkThreeMessages() throws InterruptedException {
//        wait = new WebDriverWait(driver, 20);
//        WebElement el;
        Thread.sleep(3000);
        System.out.println(messages.size());
        for (int i = 0; i < 3; i++) {
//           el = wait.until(ExpectedConditions.visibilityOf(messages.get(i)));
//             el = wait.until(ExpectedConditions.elementToBeClickable(messages.get(i)));
            messages.get(i).click();
//            el.click();
        }
        //System.out.println(messages.size());
        return messages.size();
    }

    public void openImportantFolder() {
        searchField.sendKeys("is:important");
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean deleteLetters() {
        selectForDelete.click();
        delete.click();
        return true;
    }
}
