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
        boolean existsByEmail = authorRepository.existsByEmail(authorRequest.getEmail());

        if (existsByEmail) return ResponseEntity.badRequest().body(String.format("Autor(a) com email %s já cadastrado(a)!", authorRequest.getEmail()));

        Author newAuthor = authorRequest.toModel();
        authorRepository.save(newAuthor);
        return ResponseEntity.ok().build();
    }

}
