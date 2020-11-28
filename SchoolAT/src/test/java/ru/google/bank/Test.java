package ru.google.bank;

import org.junit.jupiter.api.Assertions;
import ru.google.bank.object.GoogleSearch;
import ru.google.bank.object.Open;

import java.util.List;
import java.util.Map;

public class Test extends TestBase {

    final String URL = "https://www.google.ru/";
    final String URL_OPEN = "www.open.ru";

    @org.junit.jupiter.api.Test
    public void openTest(){
        GoogleSearch googleSearch = new GoogleSearch(webDriver, "Открытие");
        List<Map<String, Object>> resultSearch = googleSearch.getCollectResults();
        //resultSearch.stream().forEach(x-> System.out.println(x.get("DESCRIPTION").toString()));
        googleSearch.goPage("Банк «Открытие» — вклады, кредитные и дебетовые");
        Open open = new Open(webDriver);
        List<Map<String,String>> collectExchangeRates = open.getCollectExchangeRates();
        System.out.println(collectExchangeRates.size());
        System.out.println(collectExchangeRates);

        Assertions.assertTrue(
                Double.parseDouble(
                        collectExchangeRates.stream()
                                .filter(x->x.get("Валюта обмена").contains("USD"))
                                .findFirst()
                                .get().get("Банк покупает").replace(",","."))
                        <
                        Double.parseDouble(
                                collectExchangeRates.stream()
                                        .filter(x->x.get("Валюта обмена").contains("USD"))
                                        .findFirst()
                                        .get().get("Банк продает").replace(",","."))
        );
    }
}
