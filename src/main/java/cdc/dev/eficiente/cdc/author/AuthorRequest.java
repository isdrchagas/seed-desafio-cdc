package cdc.dev.eficiente.cdc.author;

import cdc.dev.eficiente.cdc.validator.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthorRequest {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public AuthorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
