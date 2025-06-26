package L01_Shampoo_Company.repositories;

import L01_Shampoo_Company.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    //E04. Create a method that selects all ingredients, which name starts with given letters.
    List<Ingredient> findByNameIsStartingWith(String symbols);

    //E05. Create a method that selects all ingredients, which are contained in a given list. Sort the result ascending by price.
    List<Ingredient> findByNameIsInOrderByPrice(List<String> names);

    //E09. Create a method that deletes ingredients by a given name. Use named query.
    @Transactional
    void deleteByName(String ingredientName);

    //E10. Create a method that increases the price of all ingredients by 10%. Use named query.
    @Query(" UPDATE Ingredient AS i SET i.price = i.price * 1.1")
    @Modifying
    @Transactional
    void increaseIngredientsPriceWith();

    //E11. Create a method that updates the price of all ingredients, which names are in a given list.
    @Query (" UPDATE Ingredient AS i SET i.price = i.price * 1.1 WHERE i.name IN :names")
    @Modifying
    @Transactional
    void increaseIngredientsPriceWhenIn(@Param("names") List<String> ingredientNames);
}
