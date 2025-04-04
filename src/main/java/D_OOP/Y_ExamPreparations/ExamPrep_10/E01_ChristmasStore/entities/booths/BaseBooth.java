package D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths;

import D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.common.*;
import D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.booths.interfaces.*;
import D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.cocktails.interfaces.*;
import D_OOP.Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.entities.delicacies.interfaces.*;

import java.util.*;

public class BaseBooth implements Booth {

    public static final double DEFAULT_PRICE = 0;
    public static final int DEFAULT_CAPACITY = 0;

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {

        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.numberOfPeople = DEFAULT_CAPACITY;
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.price = DEFAULT_PRICE;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople * this.pricePerPerson;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getBill() {
        double ordersBill = 0;
        for (Delicacy delicacy : delicacyOrders) {
            ordersBill += delicacy.getPrice();
        }
        for (Cocktail cocktail : cocktailOrders) {
            ordersBill += cocktail.getPrice();
        }
        return this.price + ordersBill;
    }

    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        this.price = DEFAULT_PRICE;
        this.numberOfPeople = DEFAULT_CAPACITY;
        this.isReserved = false;
    }
}
