package E01_SoftUni_Game_Store.service.implementations;

import E01_SoftUni_Game_Store.service.utilities.ValidatorUtil;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

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
}
