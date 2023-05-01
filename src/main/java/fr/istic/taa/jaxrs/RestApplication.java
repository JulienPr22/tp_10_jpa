package fr.istic.taa.jaxrs;

import fr.istic.taa.jaxrs.rest.MessageResource;
import fr.istic.taa.jaxrs.rest.SwaggerResource;
import fr.istic.taa.jaxrs.rest.TicketResource;
import fr.istic.taa.jaxrs.rest.UserResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(TicketResource.class);
        resources.add(UserResource.class);
        resources.add(MessageResource.class);
        resources.add(OpenApiResource.class);
        resources.add(SwaggerResource.class);

        return resources;
    }

}
