package D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore;

import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.core.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.core.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.cocktails.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.io.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.E01_ChristmasStore.repositories.interfaces.*;

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
