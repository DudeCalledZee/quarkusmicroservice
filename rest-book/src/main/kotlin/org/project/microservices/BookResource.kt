package org.project.microservices

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.faulttolerance.Fallback
import org.eclipse.microprofile.faulttolerance.Retry
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.jboss.logging.Logger
import java.io.IOException
import java.io.PrintWriter
import java.time.Instant

@Path("/api/books")
@Tag(name = "Book REST endpoint")
class BookResource {

    @RestClient
    lateinit var numberProxy: NumberProxy

    @Inject
    lateinit var log: Logger

    @Retry(delay = 3000, maxRetries = 3)
    @Fallback(fallbackMethod = "fallBackOnCreatingABook")
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
        return Response.status(201).entity(newBook).build()
            .also {
                log.info("Book has been created ${it.entity}")
            }
    }

    fun fallBackOnCreatingABook(book: Book): Response {
        val newBook = Book(
            isbn13 = "Needs to be set later",
            author = book.author,
            title = book.title,
            yearOfPublishing = book.yearOfPublishing,
            creationDate = book.creationDate,
            genre = book.genre,
        )
        saveBookOnDisk(newBook)
        log.warn("isb13 not created, saved book on disk")
        return Response.status(206).entity(newBook).build()
    }

    private fun saveBookOnDisk(newBook: Book) {
        try {
            PrintWriter("newBook-${Instant.now().toEpochMilli()}.json")
                .use { writer ->
                    writer.println(newBook)
                    println(newBook)
                }
        } catch (e: IOException) {
            log.error(e.message, e)
        }
    }
}
