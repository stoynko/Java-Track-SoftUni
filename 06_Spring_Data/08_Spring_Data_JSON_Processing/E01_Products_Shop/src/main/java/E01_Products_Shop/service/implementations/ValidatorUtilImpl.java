package E01_Products_Shop.service.implementations;

import E01_Products_Shop.service.utilities.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ValidatorUtilImpl implements ValidatorUtil {

    private final Validator validator;

    @Autowired
    public ValidatorUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate(E e) {
        return this.validator.validate(e);
    }

    @Override
    public <E> boolean isValid(E e) {
        return validate(e).isEmpty();
    }

    @Override
    public <E> String getViolations(E e) {
        return validator.validate(e)
                .stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(" | "));
    }
}
