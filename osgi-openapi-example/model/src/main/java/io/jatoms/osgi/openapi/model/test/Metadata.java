package io.jatoms.osgi.openapi.model.test;

import io.swagger.v3.oas.annotations.media.Schema;

public class Metadata {
    
    @Schema(description = "The unique test ID of this item", example = "8764387278298747")
    public String testid;
}