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
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger

@Path("/api/books")
@Tag(name = "Book REST endpoint")
class BookResource {

    @RestClient
    lateinit var numberProxy: NumberProxy

    @Inject
    lateinit var log: Logger

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new Book", description = "Creates a new Book with ISB number")
    fun createABook(book: Book): Response {
        val newBook = Book(
            isbn13 = numberProxy.generateISBNumbers().isbn13,
            author = book.author,
            title = book.title,
            yearOfPublishing = book.yearOfPublishing,
            creationDate = book.creationDate,
            genre = book.genre,
            )
        return Response.ok().entity(newBook).build()
            .also {
                log.info("Book has been created ${it.entity}")
            }
    }
}
