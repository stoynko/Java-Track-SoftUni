package D_OOP.X_ExamPreparations.ExamPrep_10;

import D_OOP.X_ExamPreparations.ExamPrep_10.core.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.core.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.booths.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.cocktails.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.delicacies.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.io.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.repositories.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {
        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
