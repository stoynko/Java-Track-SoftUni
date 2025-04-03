package D_OOP.X_ExamPreparations.ExamPrep_10.repositories.interfaces;

public interface CocktailRepository<T> extends Repository<T> {
    T getByName(String name);
}
