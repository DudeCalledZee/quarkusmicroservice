package org.project.microservices

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.jboss.logging.Logger
import kotlin.random.Random

@Path("/api/numbers")
@Tag(name = "Number REST Endpoint")
class NumberResource {

    @Inject
    lateinit var log: Logger

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Returns a list of ISB numbers",
        description = "Generates ISBN 10 and ISBN 13"
    )
    fun generateISBNumbers(): ISBNumbers =
        ISBNumbers(
            "10-${Random.nextInt(100_000)}",
            "13-${Random.nextInt(100_000_000)}"
        ).also {
            log.info("created ISB number: $it")
        }
}
