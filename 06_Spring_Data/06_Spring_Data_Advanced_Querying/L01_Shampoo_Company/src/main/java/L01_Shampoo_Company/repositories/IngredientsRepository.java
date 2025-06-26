package L01_Shampoo_Company.repositories;

import L01_Shampoo_Company.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    //E04. Create a method that selects all ingredients, which name starts with given letters.
    List<Ingredient> findByNameIsStartingWith(String symbols);
}
