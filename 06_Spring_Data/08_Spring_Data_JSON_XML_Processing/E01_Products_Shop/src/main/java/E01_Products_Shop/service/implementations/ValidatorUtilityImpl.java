package E01_Products_Shop.service.implementations;

import E01_Products_Shop.service.utilities.*;
import jakarta.validation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ValidatorUtilityImpl implements ValidatorUtility {

    private final Validator validator;

    public ValidatorUtilityImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate(E e) {
        return validator.validate(e);
    }

    @Override
    public <E> String getViolations(E e) {
        return validator.validate(e)
                .stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public <E> boolean isValid(E e) {
        return validator.validate(e).isEmpty();
    }
}
