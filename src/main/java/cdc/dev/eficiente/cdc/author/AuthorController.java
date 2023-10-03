package cdc.dev.eficiente.cdc.author;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @PostMapping("/author/create")
    public ResponseEntity<?> create(@RequestBody @Valid AuthorRequest authorRequest) {
        Author newAuthor = authorRequest.toModel();
        authorRepository.save(newAuthor);
        return ResponseEntity.ok().build();
    }

}
