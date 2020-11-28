package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AfterSearch extends BeforeSearch {

    public List<WebElement> gladiolus;

    public AfterSearch(WebDriver driver) {
        super(driver);
        gladiolus = driver.findElements(By.xpath("//*[@id=\"rso\"]/div[3]/div/div[1]/a"));
    }

    public List<WebElement> getGladiolus() {
        return gladiolus;
    }

}
