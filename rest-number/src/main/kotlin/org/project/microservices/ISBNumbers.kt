package org.project.microservices

import java.time.Instant

data class ISBNumbers(
    var isbn10: String = "",
    var isbn13: String = "",
    var generationDate: Instant = Instant.now()
)
