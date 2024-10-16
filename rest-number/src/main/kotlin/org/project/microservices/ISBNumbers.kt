package org.project.microservices

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.eclipse.microprofile.openapi.annotations.media.Schema

import java.time.Instant

@Schema(description = "Several ISB numbers for books")
data class ISBNumbers(
    @Schema(required = true)
    @JsonProperty("isbn_10")
    val isbn10: String,
    @Schema(required = true)
    @JsonProperty(value = "isbn_13")
    val isbn13: String,
    @JsonIgnore
    val generationDate: Instant = Instant.now()
)
