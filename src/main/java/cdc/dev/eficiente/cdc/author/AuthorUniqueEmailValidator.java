package cdc.dev.eficiente.cdc.author;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AuthorUniqueEmailValidator implements Validator {

    private final AuthorRepository authorRepository;

    public AuthorUniqueEmailValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        AuthorRequest authorRequest = (AuthorRequest) target;
        boolean existsByEmail = authorRepository.existsByEmail(authorRequest.getEmail());

        if (existsByEmail) errors.rejectValue("email", null, "Email de autor(a) " + authorRequest.getEmail() + " já cadastrado(a).");
    }
}
