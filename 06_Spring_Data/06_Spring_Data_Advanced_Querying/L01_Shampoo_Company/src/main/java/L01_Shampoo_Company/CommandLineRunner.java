package L01_Shampoo_Company;

import L01_Shampoo_Company.entities.*;
import L01_Shampoo_Company.repositories.*;
import org.springframework.stereotype.*;

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

        
    }
}
