import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    /** Users, avatar*/

    @Test
    public void firstTest1() {
        Specifications.installSpec(Specifications.requestSpec(), Specifications.responseOK());
        List<String> list = new ArrayList<>();
        Response response = given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        list = response.jsonPath().getList("data.avatar");
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            first = first.substring(first.lastIndexOf("/") + 1);
            String second = list.get(i + 1);
            second = second.substring(second.lastIndexOf("/") + 1);
            if (!first.equals(second)) {
                Assert.fail();
            }
        }
    }

    /** Register successful
     * {
     *     "id": 4,
     *     "token": "QpwL5tke4Pnpja7X4"
     * }*/

    @Test
    public void secondTest() {
        Specifications.installSpec(Specifications.requestSpec(), Specifications.responseOK());
        Map<String,String> data = new HashMap<String, String>();
        data.put("email", "eve.holt@reqres.in");
        data.put("password", "pistol");
        given()
                .body(data)
                .contentType("application/json")
                .when()
                .post("api/register")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    /** Register unsuccessful
     * {
     *     "error": "Missing password"
     * }*/
    @Test
    public void thirdTest() {
        Specifications.installSpec(Specifications.requestSpec(), Specifications.responseERROR());
        Map<String,String> data = new HashMap<String, String>();
        data.put("email", "sydney@fife");
        given()
                .body(data)
                .contentType("application/json")
                .when()
                .post("api/register")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    /** LIST <RESOURCE> */
    @Test
    public void fourthTest() {
        Specifications.installSpec(Specifications.requestSpec(), Specifications.responseOK());
        List<Integer> list = given()
                .when()
                .get("api/unknown")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("data.year");
        List<Integer> copyList = new ArrayList<>();
        copyList.addAll(list);
        copyList.stream().sorted();
        if (list.equals(copyList))
            System.out.println("Данные отсортированы по годам");
        else System.out.println("Данные не отсортированы по годам");

        /** второй способ */
        Assert.assertEquals(list.stream().sorted().collect(Collectors.toList()), list);
    }
}
