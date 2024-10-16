package org.project.microservices

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.jboss.logging.Logger

@Path("/api/books")
class BookResource {

    @Inject
    lateinit var log: Logger

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createABook(book: Book): Response {
        return Response.ok().entity(book).build()
            .also {
                log.info("Book has been created ${it.entity}")
            }
    }
}
