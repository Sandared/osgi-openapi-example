package io.jatoms.osgi.openapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class ComplexItem extends ItemType {
    @Schema(description = "Complex stuff", example = "Complex stuff")
    public String some;
    @Schema(description = "Complex stuff", example = "Complex stuff")
    public String complex;
    @Schema(description = "Complex stuff", example = "Complex stuff")
    public String stuff;
}