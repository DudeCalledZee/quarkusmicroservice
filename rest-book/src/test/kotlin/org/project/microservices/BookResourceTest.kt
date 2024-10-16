package org.project.microservices

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.startsWith
import org.junit.jupiter.api.Test

@QuarkusTest
class BookResourceTest {

    @Test
    fun `should create a book`() {
        val book = """
            {
            "isbn_13": "13_23456789",
            "title": "String",
            "author": "String",
            "year_of_publishing": 1989,
            "genre": "String"
            }
        """.trimIndent()

        given()
            .contentType("application/json")
            .body(book)
            .`when`().post("/api/books")
            .then()
            .statusCode(200)
            .body("isbn_13", startsWith("13_"))
            .body("title", `is` ("String"))
            .body("author", `is` ("String"))
            .body("year_of_publishing", `is` (1989))
            .body("genre", `is` ("String"))
    }

}
