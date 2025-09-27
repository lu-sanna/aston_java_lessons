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

        //GET Request без параметров
        @Test
        void testGetRequestWithoutParams() {
            given()
                    .baseUri(baseUrl)
            .when()
                    .get("/get")
            .then()
                    .statusCode(200)
                    .body("args", notNullValue());   // проверяем что args пустой
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

        //POST Request - Form Data без параметров
        @Test
        void testPostFormDataWithoutParams(){
            given()
                    .baseUri(baseUrl)
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .when()
                    .post("/post")
            .then()
                    .statusCode(200)
                    .body("form", notNullValue());
        }

        // 3. POST Request - Raw Text - использует простой текст
        @Test
        void testPostRawText() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
                    .body("hello world")
            .when()
                    .post("/post")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("hello world"));
        }

        // POST Request - Raw Text без тела
        @Test
        void testPostRawTextWithoutBody() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
            .when()
                    .post("/post")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("")); // проверяем что data пустая строка
        }

        // 4. PUT Request - использует простой текст
        @Test
        void testPutRequest() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
                    .body("put data")
            .when()
                    .put("/put")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("put data"));
        }

        //PUT Request без тела
        @Test
        void testPutRequestWithoutBody() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
            .when()
                    .put("/put")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("")); // проверяем что data пустая строка
        }


        // 5. PATCH Request - использует простой текст
        @Test
        void testPatchRequest() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
                    .body("patch data")
            .when()
                    .patch("/patch")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("patch data"));
        }

        //PATCH Request без тела
        @Test
        void testPatchRequestWithoutBody() {
           given()
                    .baseUri(baseUrl)
                   .contentType("text/plain")
           .when()
                    .patch("/patch")
           .then()
                    .statusCode(200)
                    .body("data", equalTo("")); // проверяем что data пустая строка
        }

        // 6. DELETE Request - использует простой текст
        @Test
        void testDeleteRequest() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
                    .body("delete data")
            .when()
                    .delete("/delete")
            .then()
                    .statusCode(200)
                    .body("data", equalTo("delete data"));
        }

        //DELETE Request без тела
        @Test
        void testDeleteRequestWithoutBody() {
            given()
                    .baseUri(baseUrl)
                    .contentType("text/plain")
            .when()
                    .delete("/delete")
           .then()
                    .statusCode(200)
                    .body("data", notNullValue());
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
