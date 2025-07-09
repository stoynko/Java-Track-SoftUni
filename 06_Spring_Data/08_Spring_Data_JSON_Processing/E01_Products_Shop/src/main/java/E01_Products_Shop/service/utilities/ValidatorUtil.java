package E01_Products_Shop.service.utilities;

import jakarta.validation.*;
import java.util.*;

public interface ValidatorUtil {

    <E>Set<ConstraintViolation<E>> validate(E e);
    <E>boolean isValid(E e);
    <E> String getViolations(E e);
}
