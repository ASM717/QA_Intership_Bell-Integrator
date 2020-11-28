package com.google;

import com.google.page.factrory.GoogleSearch;
import com.google.page.object.GoogleAfterSearch;
import com.google.page.object.GoogleBeforeSearch;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Test extends TestBase {

    /*@org.junit.jupiter.api.Test
    public void firstTest(){
        webDriver.get("https://www.google.ru/");
        String title = webDriver.getTitle();
        System.out.println(title);
        Assertions.assertTrue(title.equals("Google"));
    }*/

    @org.junit.jupiter.api.Test
    public void findFlower() {
        webDriver.get("https://www.google.ru/");
        WebElement inputField;
        inputField = webDriver.findElement(By.cssSelector(".gLFyf.gsfi")); //gLFyf gsfi
        WebElement findButton;
        findButton = webDriver.findElement(By.cssSelector(".gNO89b"));

        inputField.click();
        inputField.sendKeys("Гладиолус");
        findButton.click();
        System.out.println("готово!!!!!!");
        //String urls = webDriver.findElement
        // (By.xpath("/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[1]/a/h3"))
        // .getText();
        //System.out.println(urls);
        List<WebElement> resultSearch = webDriver.findElements(By.xpath
                ("/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[1]/a/h3"));

        resultSearch.stream().forEach(x-> System.out.println(x.getText()));
        Assertions.assertTrue(
                resultSearch.stream().anyMatch(x->x.getText().contains
                        ("Шпажник — Википедия")),
                "не найдено"
        );
    }

    @org.junit.jupiter.api.Test
    public void findFlowersPO(){
        webDriver.get("https://www.google.ru/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(webDriver);
        googleBeforeSearch.findFlowers("Гладиолус");
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(webDriver);
        Assertions.assertTrue(
                googleAfterSearch.getListFlowers().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")),
                "не найдено"
        );
    }

    @org.junit.jupiter.api.Test
    public void findFlowersPF(){
        webDriver.get("https://www.google.ru/");
        GoogleSearch googleSearch = PageFactory.initElements(webDriver, GoogleSearch.class);
        googleSearch.findFlowers("Гладиолус");
        Assertions.assertTrue(
                googleSearch.getListFlowers().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")),
                "не найдено"
        );
    }
}
