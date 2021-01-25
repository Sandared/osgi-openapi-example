package io.jatoms.osgi.openapi.example.restapi;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;


import static org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Component
public class OpenAPIIntegration {

    private final Logger log = LoggerFactory.getLogger(ApiV1.class);

    private ServiceRegistration<OpenAPI> registration;

    @Activate
    private void acitvate(BundleContext context){
        try {
            OpenAPI api = new OpenAPI();

            // We set these informations here, as the @OpenAPI annotation doesn't seem to get picked up if present on the Application class (ApiV1)
            api.info(
                new Info()
                .title(Doc.Api.Info.title)
                .description(Doc.Api.Info.description)
                .contact(
                    new Contact()
                        .name("jatoms team")
                        .url("https://www.jatoms.io")
                        .email("info@jatoms.io")
                )
                .extensions(
                    Map.of(
                        "x-logo", Map.of("url", "https://github.com/Sandared/osgi-openapi-example/raw/main/logo.png", "altText", "jatoms Logo"),
                        "x-tagGroups", List.of(
                            Map.of("name", "Item", "tags", List.of(Doc.Api.Tags.item)),
                            Map.of("name", "Test", "tags", List.of(Doc.Api.Tags.test))
                        )
                    )
                )
            )
            .tags(List.of(new Tag().name(Doc.Api.Tags.item).description("Item operations"), new Tag().name(Doc.Api.Tags.test).description("test")));
            Hashtable<String, Object> props = new Hashtable<>();
            props.put(JAX_RS_APPLICATION_SELECT, "(osgi.jaxrs.name=apiv1)");
            registration = context.registerService(OpenAPI.class, api, props);
        } catch (Exception e) {
            log.warn("Could not activate OpenAPI resource!", e);
            throw e;
        }
    }

    @Deactivate
    private void deactivate(){
        try {
            registration.unregister();
        } catch (Exception e) {
            log.warn("Could not unregister OpenAPI registration!", e);
            throw e;
        }
    }
    
}
