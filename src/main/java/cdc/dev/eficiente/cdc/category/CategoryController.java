package cdc.dev.eficiente.cdc.category;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryUniqueNameValidator categoryUniqueNameValidator;

    public CategoryController(CategoryRepository categoryRepository, CategoryUniqueNameValidator categoryUniqueNameValidator) {
        this.categoryRepository = categoryRepository;
        this.categoryUniqueNameValidator = categoryUniqueNameValidator;
    }

    @InitBinder("categoryRequest")
    void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(categoryUniqueNameValidator);
    }

    @PostMapping("/category/create")
    public ResponseEntity<?> create(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category newCategory = categoryRequest.toModel();
        categoryRepository.save(newCategory);
        return ResponseEntity.ok().build();
    }
}
