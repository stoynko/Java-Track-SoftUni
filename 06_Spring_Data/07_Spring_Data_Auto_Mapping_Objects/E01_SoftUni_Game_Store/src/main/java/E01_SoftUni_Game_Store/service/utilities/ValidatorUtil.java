package E01_SoftUni_Game_Store.service.utilities;

import jakarta.validation.*;

import java.util.*;

public interface ValidatorUtil {

    <E>Set<ConstraintViolation<E>> validate(E e);
    <E> boolean isValid(E e);
    <E> String getViolations(E e);
}
