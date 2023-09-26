package cdc.dev.eficiente.cdc.category;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryUniqueNameValidator implements Validator {

    private final CategoryRepository categoryRepository;

    public CategoryUniqueNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoryRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryRequest categoryRequest = (CategoryRequest) target;

        if (categoryRepository.existsByName(categoryRequest.getName())) errors.rejectValue("name", null, "Já existe uma categoria cadastrada com esse nome!");

    }
}
