package cdc.dev.eficiente.cdc.author;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final AuthorUniqueEmailValidator authorUniqueEmailValidator;

    public AuthorController(AuthorRepository authorRepository, AuthorUniqueEmailValidator authorUniqueEmailValidator) {
        this.authorRepository = authorRepository;
        this.authorUniqueEmailValidator = authorUniqueEmailValidator;
    }

    @InitBinder("authorRequest")
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(authorUniqueEmailValidator);
    }

    @Transactional
    @PostMapping("/author/create")
    public ResponseEntity<?> create(@RequestBody @Valid AuthorRequest authorRequest) {
        Author newAuthor = authorRequest.toModel();
        authorRepository.save(newAuthor);
        return ResponseEntity.ok().build();
    }

}
