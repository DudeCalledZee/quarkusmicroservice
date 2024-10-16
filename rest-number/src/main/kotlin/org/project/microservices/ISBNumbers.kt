package org.project.microservices

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

import java.time.Instant

data class ISBNumbers(
    @JsonProperty("isbn_10")
    val isbn10: String,
    @JsonProperty(value = "isbn_13")
    val isbn13: String,
    @JsonIgnore
    val generationDate: Instant = Instant.now()
)
