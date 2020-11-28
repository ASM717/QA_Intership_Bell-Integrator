package google;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.junit.Assertions;
import org.junit.Assert;

public class MyStepDefs extends Steps {
    @Given("go to website '(.*)'")
    public void goToWebsiteHttpsWwwGoogleRu(String url) {
        openChrome();
        driver.get(url);
    }

    @Then("check title '(.*)'")
    public void checkTitleGoogle(String checkTitle) {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(checkTitle));
    }

    @Then("stop work")
    public void stopWork() {
        closeChrome();
    }

    @Then("search '(.*)'")
    public void searchГладиолус(String word) {
        BeforeSearch beforeSearch = new BeforeSearch(driver);
        beforeSearch.findElem(word);

    }

    @Then("search on page '(.*)'")
    public void searchOnPageШпажникВикипедия(String keyWord) {
        AfterSearch afterSearch = new AfterSearch(driver);
        Assert.assertTrue(
                "не найдено",
                afterSearch.getGladiolus().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")));
        System.out.println(keyWord);
    }
}
