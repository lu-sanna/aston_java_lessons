package postmanecho;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

    public class RequestMethodsTest {
        private String baseUrl = "https://postman-echo.com";

        // 1. GET Request - использует foo1=bar1, foo2=bar2
        @Test
        void testGetRequest() {
            given()
                    .baseUri(baseUrl)
                    .queryParam("foo1", "bar1")
                    .queryParam("foo2", "bar2")
            .when()
                    .get("/get")
            .then()
                    .statusCode(200)
                    .body("args.foo1", equalTo("bar1"))
                    .body("args.foo2", equalTo("bar2"));
        }

        // 2. POST Request - Form Data - использует foo1=bar1, foo2=bar2
        @Test
        void testPostFormData() {
            given()
                    .baseUri(baseUrl)
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .formParam("foo1", "bar1")
                    .formParam("foo2", "bar2")
            .when()
                    .post("/post")
            .then()
                    .statusCode(200)
                    .body("form.foo1", equalTo("bar1"))
                    .body("form.foo2", equalTo("bar2"));
        }

        // 3. POST Request - Raw Text - использует простой текст
        @Test
        void testPostRawText() {
            given()
                    .baseUri(baseUrl)
                    .body("hello world")
            .when()
                    .post("/post")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("hello world"));
        }

        // 4. PUT Request - использует простой текст
        @Test
        void testPutRequest() {
            given()
                    .baseUri(baseUrl)
                    .body("put data")
            .when()
                    .put("/put")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("put data"));
        }

        // 5. PATCH Request - использует простой текст
        @Test
        void testPatchRequest() {
            given()
                    .baseUri(baseUrl)
                    .body("patch data")
            .when()
                    .patch("/patch")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("patch data"));
        }

        // 6. DELETE Request - использует простой текст
        @Test
        void testDeleteRequest() {
            given()
                    .baseUri(baseUrl)
                    .body("delete data")
            .when()
                    .delete("/delete")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("delete data"));
        }


        //тест для проверки структуры ответа
        @Test
        void testResponseStructure() {
            given()
                    .baseUri(baseUrl)
            .when()
                    .get("/get")
            .then()
                    .statusCode(200)
                    .body("args", notNullValue()) // проверяем что args существует
                    .body("headers", notNullValue()) // проверяем что headers существует
                    .body("url", notNullValue()); // проверяем что url существует
        }
    }
