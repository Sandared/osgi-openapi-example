package io.jatoms.osgi.openapi.example.restapi;

import java.util.List;

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

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsApplicationSelect;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jatoms.osgi.openapi.model.ExceptionResponse;
import io.jatoms.osgi.openapi.model.Item;
import io.jatoms.osgi.openapi.model.Metadata;
import io.jatoms.osgi.openapi.model.SimpleItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@JaxrsResource
@Path("/item")
@JaxrsApplicationSelect("(osgi.jaxrs.name=apiv1)")
@Component(service = ItemEndpoint.class, scope = ServiceScope.PROTOTYPE)
@CrossOriginResourceSharing(
    allowAllOrigins = true,
    allowCredentials = true,
    allowHeaders = {"origin", "content-type", "accept", "authorization"}
)
public class ItemEndpoint {
    private final Logger log = LoggerFactory.getLogger(ItemEndpoint.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "GET find all existing Items", description = "Retrieves all existing Items", tags = {Doc.Api.Tags.item})
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Metadata.class))))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response getAllItems() {
        log.info("GET /item");
        return Response.ok(List.of(new Metadata())).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "POST create new Item", description = "Creates a new Item with the given Item data", tags = {Doc.Api.Tags.item})
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Metadata.class)))
    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response createItem(Item data){
        log.info("POST /item");
        // TODO: create a Response with Metadata in its body
        return null;
    }

    @PUT
    @Path("/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "PUT update existing Item", description = "Updates an existing Item with the given Item data and the given ID", tags = {Doc.Api.Tags.item})
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Metadata.class)))
    @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response updateItem(@PathParam("id") Long id, Item data){
        log.info("PUT /item/{}", id);
        // TODO: create a Response with Metadata in its body
        return null;
    }

    @GET
    @Path("/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "GET find Item by ID", description = "Returns a single Item with the given ID", tags = {Doc.Api.Tags.item})
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Item.class)))
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response getItem(@PathParam("id") Long id) {
        log.info("GET /item/{}", id);
        // TODO: create a Response with Item in its body
        return null;
    }

    @DELETE
    @Path("/{id: \\d+}")
    @Operation(summary = "DELETE removes an existing Item", description = "Removes the Item with the given ID", tags = {Doc.Api.Tags.item})
    @ApiResponse(responseCode = "204", content = @Content(schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "5xx", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public Response deleteItem(@PathParam("id") Long id) {
        log.info("DELETE /item/{}", id);
        // TODO: create a Response with no body
        return null;
    }
}
