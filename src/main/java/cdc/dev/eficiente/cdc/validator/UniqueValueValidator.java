package cdc.dev.eficiente.cdc.validator;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private final EntityManager entityManager;
    private Class<?> domainClass;
    private String fieldName;

    public UniqueValueValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(UniqueValue param) {
        domainClass = param.domainClass();
        fieldName = param.fieldName();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Boolean exists = (Boolean) entityManager.createQuery("""
                       SELECT COUNT(1) > 0 FROM %s WHERE %s = :value
                """.formatted(domainClass.getName(), fieldName)
        ).setParameter("value", object).getSingleResult();

        return !exists;
    }
}
