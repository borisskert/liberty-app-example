package de.borisskert.liberty.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("greeting")
@RequestScoped
public class ExampleEndpoint {

    @Inject
    @ConfigProperty(name = "my.app.property", defaultValue = "Hello World from default value")
    private String property;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting() {
        return Optional.ofNullable(property)
                .orElse("Hello World from class");
    }
}
