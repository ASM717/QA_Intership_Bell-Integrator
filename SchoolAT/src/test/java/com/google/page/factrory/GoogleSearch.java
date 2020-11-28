package com.google.page.factrory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GoogleSearch {
    private WebDriver webDriver;

    @FindBy(how = How.CSS, css=".gLFyf.gsfi")
    WebElement inputField;

    @FindBy(how= How.CSS, css=".gNO89b")
    WebElement findButton;

    @FindAll(@FindBy(how = How.XPATH, using="/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[1]/a/h3"))
    List<WebElement> listFlowers;

    public GoogleSearch(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void findFlowers(String key){
        inputField.click();
        inputField.sendKeys(key);
        findButton.click();
    }

    public List<WebElement> getListFlowers(){
        return listFlowers;
    }
}
