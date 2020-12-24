package io.jatoms.osgi.openapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class SimpleItem extends ItemType {
    @Schema(description = "Simple stuff", example = "Simple stuff")
    public String simpleStuff;
}