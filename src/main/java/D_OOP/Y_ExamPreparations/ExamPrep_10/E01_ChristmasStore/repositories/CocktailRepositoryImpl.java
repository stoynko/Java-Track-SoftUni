package D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories;

import D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.cocktails.interfaces.*;
import D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces.*;

import java.util.*;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails = new ArrayList<>();
    }

    @Override
    public void add(Cocktail cocktail) {
        this.cocktails.add(cocktail);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(this.cocktails);
    }

    @Override
    public Cocktail getByName(String name) {
        return this.cocktails.stream().filter(cocktail -> cocktail.getName().equals(name)).findFirst().orElse(null);
    }
}
