package io.jatoms.osgi.openapi.example.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsApplicationSelect;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jatoms.osgi.openapi.model.ExceptionResponse;
import io.jatoms.osgi.openapi.model.test.Test;
import io.jatoms.osgi.openapi.model.test.Metadata;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@JaxrsResource
@Path("/test")
@JaxrsApplicationSelect("(osgi.jaxrs.name=apiv1)")
@Component(service = TestEndpoint.class, scope = ServiceScope.PROTOTYPE)
public class TestEndpoint {
    private final Logger log = LoggerFactory.getLogger(TestEndpoint.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "GET find all existing Tests", description = "Retrieves all existing Tests", tags = {Doc.Api.Tags.test})
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Metadata.class))))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response getAllTests() {
        log.info("GET /test");
        // return some Response with all tests set as Metadata in a list in the body
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "POST create new Test", description = "Creates a new Test with the given Test data", tags = {Doc.Api.Tags.test})
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Metadata.class)))
    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response createTest(Test data){
        log.info("POST /test");
        // TODO: create a Response with Metadata in its body
        return null;
    }

    @PUT
    @Path("/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "PUT update existing Test", description = "Updates an existing Test with the given Test data and the given ID", tags = {Doc.Api.Tags.test})
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Metadata.class)))
    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response updateTest(@PathParam("id") Long id, Test data){
        log.info("PUT /test/{}", id);
        // TODO: create a Response with Metadata in its body
        return null;
    }

    @GET
    @Path("/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "GET find Test by ID", description = "Returns a single Test with the given ID", tags = {Doc.Api.Tags.test})
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Test.class)))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response getTest(@PathParam("id") Long id) {
        log.info("GET /test/{}", id);
        // TODO: create a Response with Test in its body
        return null;
    }

    @DELETE
    @Path("/{id: \\d+}")
    @Operation(summary = "DELETE removes an existing Test", description = "Removes the Test with the given ID", tags = {Doc.Api.Tags.test})
    @ApiResponse(responseCode = "204", content = @Content(schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response deleteTest(@PathParam("id") Long id) {
        log.info("DELETE /test/{}", id);
        // TODO: create a Response with no body
        return null;
    }
}