package cdc.dev.eficiente.cdc.author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByEmail(String email);
}
