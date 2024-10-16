package org.project.microservices

import com.fasterxml.jackson.annotation.JsonProperty
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.Instant

@Schema(description = "This is a book")
data class Book(
    @JsonProperty("isbn_13")
    @Schema(required = true)
    val isbn13: String = "",
    @Schema(required = true)
    val title: String = "",
    val author: String = "",
    @JsonProperty("year_of_publishing")
    val yearOfPublishing: Int = 0,
    val genre: String = "",
    @JsonProperty("creation_date")
    val creationDate: Instant = Instant.now(),
)
