package com.google.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleBeforeSearch {
    protected WebDriver webDriver;
    private WebElement inputField;
    private WebElement findButton;

    public GoogleBeforeSearch(WebDriver webDriver){
        this.webDriver = webDriver;
        this.inputField = webDriver.findElement(By.xpath("//*[@name=\"q\" and @title=\"Поиск\"]"));
        this.findButton = webDriver.findElement(By.xpath("//*[@name=\"btnK\" and @value=\"Поиск в Google\"]"));
    }

    public void findFlowers(String key){
        inputField.click();
        inputField.sendKeys(key);
        findButton.click();
    }
}
