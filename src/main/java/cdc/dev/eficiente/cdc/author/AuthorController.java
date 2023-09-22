package cdc.dev.eficiente.cdc.author;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    private final EntityManager entityManager;

    public AuthorController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @PostMapping("/author/create")
    public ResponseEntity<?> create(@RequestBody @Valid AuthorRequest authorRequest) {
        Author newAuthor = authorRequest.toModel();
        entityManager.persist(newAuthor);
        return ResponseEntity.ok().build();
    }

}
