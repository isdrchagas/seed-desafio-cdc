package cdc.dev.eficiente.cdc.category;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/category/create")
    public ResponseEntity<?> create(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category newCategory = categoryRequest.toModel();
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().build();
    }
}
