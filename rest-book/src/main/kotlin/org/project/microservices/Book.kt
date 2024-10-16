package org.project.microservices

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class Book(
    @JsonProperty("isbn_13")
    val isbn13: String = "",
    val title: String = "",
    val author: String = "",
    @JsonProperty("year_of_publishing")
    val yearOfPublishing: Int = 0,
    val genre: String = "",
    @JsonProperty("creation_date")
    val creationDate: Instant = Instant.now(),
)
