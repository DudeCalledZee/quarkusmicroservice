package org.project.microservices

import jakarta.ws.rs.ApplicationPath
import jakarta.ws.rs.core.Application
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Contact
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@ApplicationPath("/")
@OpenAPIDefinition(
    info = Info(
        title = "Number Microservice",
        description = "This microservice generate book numbers",
        version = "1.0.0",
        contact = Contact(name = "@Zee", url = "https://zee.com")
    ),
    tags = [Tag(name = "Numbers", description = "A numbers api service")]
)
class NumberMicoService : Application() {
}
