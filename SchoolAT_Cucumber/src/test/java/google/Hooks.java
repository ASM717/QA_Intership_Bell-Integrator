package google;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before(order = 1)
    public void start(){
        System.out.println("Начало тестирования");
    }

    @After(order = 1)
    public void end(){
        System.out.println("Конец тестирования");
    }
}
