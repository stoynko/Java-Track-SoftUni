package L01_Shampoo_Company;

import L01_Shampoo_Company.entities.*;
import L01_Shampoo_Company.repositories.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.math.*;
import java.sql.*;
import java.util.*;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final ShampooRepository shampoosRepository;
    private final IngredientsRepository ingredientsRepository;

    public CommandLineRunner(ShampooRepository shampoosRepository, IngredientsRepository ingredientsRepository) {
        this.shampoosRepository = shampoosRepository;
        this.ingredientsRepository = ingredientsRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        //E01. Create a method that selects all shampoos with a given size, ordered by shampoo id.
        //List<Shampoo> shampoosBySize = shampoosRepository.findBySizeOrderById(Size.MEDIUM);
        //shampoosBySize.forEach(System.out::println);

        //E02. Create a method that selects all shampoos with a given size or label id. Sort the result ascending by price.
        //List<Shampoo> shampoosBySizeOrLabel = shampoosRepository.findBySizeOrLabelIdOrderByPrice(Size.MEDIUM, 10);
        //shampoosBySizeOrLabel.forEach(System.out::println);

        //E03. Create a method that selects all shampoos, which price is higher than a given price. Sort the result descending by price.
        //List<Shampoo> shampoosWithPriceMoreThan = shampoosRepository.findByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(5));
        //shampoosWithPriceMoreThan.forEach(System.out::println);

        //E04. Create a method that selects all ingredients, which name starts with given letters.
        //List<Ingredient> ingredientsWithNameAs = ingredientsRepository.findByNameIsStartingWith("M");
        //ingredientsWithNameAs.forEach(ingredient -> System.out.println(ingredient.getName()));

        //E05. Create a method that selects all ingredients, which are contained in a given list. Sort the result ascending by price.
        //List<Ingredient> ingredientsWithNameAs = ingredientsRepository.findByNameIsInOrderByPrice(List.of("Lavender", "Herbs", "Apple"));
        //ingredientsWithNameAs.forEach(ingredient -> System.out.println(ingredient.getName()));

        //E06. Create a method that counts all shampoos with price lower than a given price.
        //int shampoosWithPriceLessThan = shampoosRepository.countByPriceLessThan(BigDecimal.valueOf(8.5));
        //System.out.println(shampoosWithPriceLessThan);

        //E07. Create a method that selects all shampoos with ingredients included in a given list.
        //List<Shampoo> shampoosWithIngredientsIn = shampoosRepository.findByIngredientsInList(List.of("Berry", "Mineral-Collagen"));
        //shampoosWithIngredientsIn.forEach(shampoo -> System.out.println(shampoo.getBrand()));

        //E08. Create a method that selects all shampoos with ingredients less than a given number.
        //List<Shampoo> shampoosWithIngredientsLessThan = shampoosRepository.findByIngredientsLessThan(2);
        //shampoosWithIngredientsLessThan.forEach(System.out::println);

        //E09. Create a method that deletes ingredients by a given name. Use named query.
        //ingredientsRepository.deleteByName("Lavender");

        //E10. Create a method that increases the price of all ingredients by 10%. Use named query.
        //ingredientsRepository.increaseIngredientsPriceWith();

        //E11. Create a method that updates the price of all ingredients, which names are in a given list.
        //ingredientsRepository.increaseIngredientsPriceWhenIn(List.of("Lavender", "Aloe Vera"));
    }
}
