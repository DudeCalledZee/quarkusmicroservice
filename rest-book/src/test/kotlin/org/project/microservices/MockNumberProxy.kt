package org.project.microservices

import io.quarkus.test.Mock
import org.eclipse.microprofile.rest.client.inject.RestClient

@Mock
@RestClient
class MockNumberProxy: NumberProxy  {
    override fun generateISBNumbers(): ISBNThirteen = ISBNThirteen(isbn13 = "13-mock")
}
