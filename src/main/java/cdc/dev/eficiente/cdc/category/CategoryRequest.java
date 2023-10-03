package cdc.dev.eficiente.cdc.category;

import cdc.dev.eficiente.cdc.validator.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
