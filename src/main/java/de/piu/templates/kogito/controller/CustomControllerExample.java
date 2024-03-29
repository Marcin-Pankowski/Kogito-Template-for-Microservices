package de.piu.templates.kogito.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import org.kie.kogito.incubation.application.AppRoot;
import de.piu.templates.kogito.dto.Person;

import java.io.StringReader;


@Path("/custom-rest-Endpoint")
public class CustomControllerExample {

    @Inject
    AppRoot appRoot;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String returnString(Person person) {


        return person.getName() + " " + person.getAge();
    }
}
