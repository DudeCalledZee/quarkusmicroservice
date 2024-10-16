package org.project.microservices

import com.fasterxml.jackson.annotation.JsonProperty

data class ISBNThirteen(

    @JsonProperty("isbn_13")
    val isbn13: String
)
