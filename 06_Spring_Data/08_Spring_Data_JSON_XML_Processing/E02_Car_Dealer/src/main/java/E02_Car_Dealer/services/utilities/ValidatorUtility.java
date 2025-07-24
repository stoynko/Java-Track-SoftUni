package E02_Car_Dealer.services.utilities;

import jakarta.validation.*;
import java.util.*;

public interface ValidatorUtility {

    <E> Set<ConstraintViolation<E>> validate (E e);
    <E> String getViolations(E e);
    <E> boolean isValid(E e);
}
