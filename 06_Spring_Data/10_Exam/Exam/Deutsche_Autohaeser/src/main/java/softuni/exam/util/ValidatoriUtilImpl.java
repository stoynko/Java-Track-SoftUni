package softuni.exam.util;

import org.springframework.stereotype.*;
import org.springframework.validation.*;

@Service
public class ValidatoriUtilImpl implements ValidationUtil {

    private final Validator validator;

    public ValidatoriUtilImpl(Validator validator) {
        this.validator = validator;

    }

    @Override
    public <E> boolean isValid(E entity) {
        return (!validator.validateObject(entity).hasErrors());
    }
}

/*private final Validator validator;

    public ValidatorUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> Boolean isValid(E e) {
        return validate(e).isEmpty();
    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate(E e) {
        return this.validator.validate(e);
    }

    @Override
    public <E> String getViolations(E e) {
        return validator.validate(e).stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
    }*/