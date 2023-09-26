package cdc.dev.eficiente.cdc.category;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
