package org.project.microservices

import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jboss.logging.Logger
import kotlin.random.Random

@Path("/api/books")
class BookResource {

    @Inject
    lateinit var log: Logger


}
