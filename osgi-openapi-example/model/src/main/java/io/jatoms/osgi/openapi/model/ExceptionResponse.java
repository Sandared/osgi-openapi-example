package io.jatoms.osgi.openapi.model;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * ErrorResponse used for IETF RFC 7807 compliant error messages
 */
public class ExceptionResponse {

    /**
     * A URI identifier that categorizes the error, e.g. /auth/001
     */
    @Schema(description = "A URI identifier that categorizes the error", example = "/auth/001")
    public String type = "/unexpected/000";

    /**
     * Brief, human-readable message that can be displayed by the client, e.g., "Incorrect username"
     */
    @Schema(description = "Brief, human-readable message that can be displayed by the client", example = "Incorrect username")
    public String title = "No title provided";

    /**
     * OPTIONAL - HTTP response code, e.g., 4xx, 5xx 
     */
    @Schema(description = "Brief, human-readable message that can be displayed by the client", example = "404")
    public Integer status = 500;

    /**
     * Human-readable explanation of the error, e.g., "Username must have at least one special character"
     */
    @Schema(description = "Human-readable explanation of the error", example = "Username must have at least one special character")
    public String detail = " No detail provided";

    /**
     * A URI that identifies the specific occurrence of the error for later error inspection, e.g., /auth/001/abc-123-qwertz 
     */
    @Schema(description = "A URI that identifies the specific occurrence of the error for later error inspection", example = "/auth/001/abc-123-qwertz")
    public final String instance = type + "/" + UUID.randomUUID().toString();

}
