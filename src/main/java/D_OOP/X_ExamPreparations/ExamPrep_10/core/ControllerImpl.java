package D_OOP.X_ExamPreparations.ExamPrep_10.core;

import D_OOP.X_ExamPreparations.ExamPrep_10.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.core.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.booths.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.booths.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.cocktails.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.cocktails.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.delicacies.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.entities.delicacies.interfaces.*;
import D_OOP.X_ExamPreparations.ExamPrep_10.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    public static final double STARTING_REVENUE = 0;

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double storeRevenue;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.storeRevenue = STARTING_REVENUE;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        if (this.delicacyRepository.getAll().stream().anyMatch(d -> d.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        Delicacy delicacy = null;
        switch (type) {
            case "Gingerbread": delicacy = new Gingerbread(name, price);
                break;
            case "Stolen": delicacy = new Stolen(name, price);
        }

        this.delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, delicacy.getClass().getSimpleName());
    }

    @Override
    public String addCocktail(String type, String name, int portion, String brand) {

        if (this.cocktailRepository.getAll().stream().anyMatch(c -> c.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        Cocktail cocktail = null;
        switch (type) {
            case "MulledWine": cocktail = new MulledWine(name, portion, brand);
                break;
            case "Hibernation": cocktail = new Hibernation(name, portion, brand);
        }

        this.cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, cocktail.getBrand());
    }

    @Override
    public String addBooth(String type, int tableNumber, int capacity) {

        if (this.boothRepository.getAll().stream().anyMatch(b -> b.getBoothNumber() == tableNumber)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, tableNumber));
        }

        Booth booth = null;
        switch (type) {
            case "OpenBooth": booth = new OpenBooth(tableNumber, capacity);
                break;
            case "PrivateBooth": booth = new PrivateBooth(tableNumber, capacity);
        }

        this.boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, tableNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = boothRepository.getAll().stream().filter(b -> !b.isReserved() && b.getCapacity() >= numberOfPeople).findAny().orElse(null);
        if (booth != null) {
            booth.reserve(numberOfPeople);
            return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
        } else {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
    }

    @Override
    public String leaveBooth(int tableNumber) {
        Booth booth = boothRepository.getByNumber(tableNumber);
        double boothTotalBill = 0;
        if (booth != null) {
            boothTotalBill += booth.getBill();
            storeRevenue += boothTotalBill;
            booth.clear();
        }
        return String.format(OutputMessages.BILL, tableNumber, boothTotalBill);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, storeRevenue);
    }
}
