package PageObjectSberbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageObject {
    private WebDriver driver;
    private WebElement elemMenu;
    //private String header = "//*[@class=\"master_open_menu\"]//div//div//div";
    //private String menu = "//*[@class=\"master_open_menu\"]//li/span";
    //private String subMenu = "//*[@class=\"master_open_menu\"]//li/div";
    private final LinkedHashMap<String, Map<String, String>> mapMenu = new LinkedHashMap<>();


    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.sberbank-ast.ru/");
        elemMenu = driver.findElement(By.xpath("//*[@class='master_open_menu']"));

    }

    public void collections() {
        Map<String, List<WebElement>> menuHead = new HashMap<>();
        elemMenu.findElements(By.xpath("//li/span"))
                .forEach(x -> menuHead.put(x.getText(), x.findElements(By.xpath
                        ("//*[contains(text(), '" + x.getText()+ "')]//parent::li//a[@href]"))));
        menuHead.forEach((k, v) -> {
            Map<String, String> map = v.stream()
                    .collect(Collectors.toMap(x -> x.getAttribute("innerHTML"),
                            x -> x.getAttribute("href")));
            /**Свойство innerHTML позволяет получить HTML-содержимое элемента в виде строки.
             https://learn.javascript.ru/basic-dom-node-properties#innerhtml-soderzhimoe-elementa*/
            mapMenu.put(k, map);
            //System.out.println(mapMenu.toString());
        });
        mapMenu
                .forEach((k, v) -> v.forEach((left, right)
                -> System.out.println("| " + k + " | " + left + " | " + right + " |")));
    }

    public void goByLink(String header, String sub) {
        WebElement webElement = driver.findElement
                (By.xpath("//span[contains(text(), '" + header + "')]/parent::li"));
        String webLink = webElement.findElement
                (By.xpath("//a[contains(text(), '" + sub + "')]")).getAttribute("href");
        driver.get(webLink);
    }
}
