package io.jatoms.osgi.openapi.model.test;

import io.jatoms.osgi.openapi.model.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;

public class Test {
    
    @Schema(description = "Name chosen by the user for this Item", example = "This is a sample Item")
    public String name = "";
    @Schema(description = "A description of this Item", example = "This item is meant only for testing purposes!")
    public String description = "";
    @Schema(description = "An identifier of an image that has previoulsy been uploaded via the /file endpoint", example = "lkj-123-asdfoih-bui4p44hi")
    public String image = "";
    @Schema(description = "Itemtype specific information, i.e., for complex items, simple items, etc.")
    public ItemType itemType;
}