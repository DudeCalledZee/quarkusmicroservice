package org.project.microservices

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.Matchers.hasKey
import org.junit.jupiter.api.Test

@QuarkusTest
class NumberResourceTest {

    @Test
    fun `should get isbn numbers`() {
        given()
            .`when`().get("/api/numbers")
            .then()
            .statusCode(200)
            .body("isbn_13", startsWith("13"))
            .body("isbn_10", startsWith("10"))
            .body(not(hasKey("generationDate")))
    }
}
