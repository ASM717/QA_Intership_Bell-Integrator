package com.google.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleAfterSearch extends GoogleBeforeSearch {
    List<WebElement> listFlowers;

    public GoogleAfterSearch(WebDriver webDriver) {
        super(webDriver);
        listFlowers = webDriver.findElements
                //(By.xpath("/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div[1]/a/h3"));
        (By.cssSelector(".V7Sr0.p5AXld.PpBGzd.YcUVQe"));
    }

    public List<WebElement> getListFlowers() {
        return listFlowers;
    }
}
