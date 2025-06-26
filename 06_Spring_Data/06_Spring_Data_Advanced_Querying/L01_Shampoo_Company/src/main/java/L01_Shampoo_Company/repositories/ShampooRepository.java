package L01_Shampoo_Company.repositories;

import L01_Shampoo_Company.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    //E01. Create a method that selects all shampoos with a given size, ordered by shampoo id.
    List<Shampoo> findBySizeOrderById(Size size);

    //E02. Create a method that selects all shampoos with a given size or label id. Sort the result ascending by price.
    List<Shampoo> findBySizeOrLabelIdOrderByPrice(Size size, int labelId);

    //E03. Create a method that selects all shampoos, which price is higher than a given price. Sort the result descending by price.
    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    //E06. Create a method that counts all shampoos with price lower than a given price.
    int countByPriceLessThan(BigDecimal price);

    //E07. Create a method that selects all shampoos with ingredients included in a given list.
    @Query("""
           SELECT s FROM Shampoo s 
           JOIN s.ingredients AS i 
           WHERE i.name IN :names
           """)
    List<Shampoo> findByIngredientsInList(@Param("names") List<String> ingredientNames);

    //E08. Create a method that selects all shampoos with ingredients less than a given number.
    @Query("""
          SELECT s FROM Shampoo s
          WHERE SIZE(s.ingredients) < :count
          """)
    List<Shampoo> findByIngredientsLessThan(@Param("count") int ingredientsCount);
}
