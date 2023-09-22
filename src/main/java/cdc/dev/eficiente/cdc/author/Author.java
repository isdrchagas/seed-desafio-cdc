package cdc.dev.eficiente.cdc.author;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt = LocalDateTime.now();
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;

    /**
     * hibernate only
     */
    @Deprecated
    public Author() {
    }

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

}