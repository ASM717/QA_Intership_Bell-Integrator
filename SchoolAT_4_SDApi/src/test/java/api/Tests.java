package api;

import api.data.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;


public class Tests {
    @Test
    public void testSD1() {
        List<DataAvatars> list = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().body()
                .extract().body().jsonPath().getList("data", DataAvatars.class);
        list.stream().forEach(x -> System.out.println(x.getAvatar()
                .substring(x.getAvatar().lastIndexOf("/") + 1)));
        List<String> list2 = new ArrayList<>();
        list.stream().forEach(x -> list2.add(x.getAvatar()
                .substring(x.getAvatar().lastIndexOf("/") + 1)));
        for (int i = 0; i < list2.size() - 1; i++) {
            if (!list2.get(i).equals(list2.get(i + 1))) {
                Assert.fail();
            }
        }
    }

    @Test
    public void testSD2() {
        LogPassUsers logPassUsers = new LogPassUsers("eve.holt@reqres.in", "pistol");
        RegUsers regUsers = given()
                .contentType("application/json")
                .body(logPassUsers)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(200)
                .assertThat()
                .extract().body().as(RegUsers.class);
        Assert.assertNotNull(regUsers.getId(), "Fail Reg");
        Assert.assertNotNull(regUsers.getToken(), "Fail Reg");

    }

    @Test
    public void testSD3() {
        LogPassUsers logPassUsers = new LogPassUsers("eve.holt@reqres.in");
        LogError logError = given()
                .contentType("application/json")
                .body(logPassUsers)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().body()
                .statusCode(400)
                .assertThat()
                .extract().body().as(LogError.class);
        Assert.assertNotNull(logError.getError(), "Fail Reg");

    }

    @Test
    public void testSD4(){
        List<DateYears> data = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().body()
                .extract().body().jsonPath().getList("data", DateYears.class);
        data.stream().forEach(x -> System.out.println(x.getYear()));
        List<DateYears> data2 = new ArrayList<>();
        data2.addAll(data);
        data2.stream().sorted();
        if (data.equals(data2))
            System.out.println("Данные отсортированы по годам");
        else System.out.println("Данные не отсортированы по годам");
    }
}
