package io.jatoms.osgi.openapi.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_itemtype_")
@JsonSubTypes({ @Type(value = ComplexItem.class, name = "complex"), @Type(value = SimpleItem.class, name = "simple")})

@Schema(discriminatorMapping = { @DiscriminatorMapping(value = "complex", schema = ComplexItem.class),
        @DiscriminatorMapping(value = "simple", schema = SimpleItem.class) })
public abstract class ItemType {
    
}