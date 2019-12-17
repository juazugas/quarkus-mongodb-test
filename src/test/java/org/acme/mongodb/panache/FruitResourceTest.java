package org.acme.mongodb.panache;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.mongodb.MongoDatabaseTestResource;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
@QuarkusTestResource(MongoDatabaseTestResource.class)
public class FruitResourceTest {

    private static final String FRUIT_NAME = "fruit";

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/fruits/hello")
          .then()
             .statusCode(200)
             .body(equalTo("hello"));
    }

    @Test
    public void testCreateEndpoint() {
        given()
          .when()
          .body("{\"name\":\""+FRUIT_NAME+"\"}")
          .contentType(ContentType.JSON)
          .post("/fruits")
          .then()
             .statusCode(200)
             .body("name", equalTo(FRUIT_NAME));
    }

}