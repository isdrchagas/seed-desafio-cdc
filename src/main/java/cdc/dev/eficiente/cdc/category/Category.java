package cdc.dev.eficiente.cdc.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    /**
     * hibernate only
     */
    @Deprecated
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
