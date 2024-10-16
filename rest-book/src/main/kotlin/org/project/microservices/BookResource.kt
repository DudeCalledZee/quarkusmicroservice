package org.project.microservices

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.jboss.logging.Logger

@Path("/api/books")
@Tag(name = "Book REST endpoint")
class BookResource {

    @Inject
    lateinit var log: Logger

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Book", description = "Creates a new Book with ISB number")
    fun createABook(book: Book): Response {
        return Response.ok().entity(book).build()
            .also {
                log.info("Book has been created ${it.entity}")
            }
    }
}
