package PageObjectSberbank;

public class Test extends TestBase {

    @org.junit.jupiter.api.Test
    public void test1() {
        PageObject pageObject = new PageObject(driver);
        pageObject.collections();
        pageObject.goByLink("Главная", "Вакансии");
    }
}
