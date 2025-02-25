package D_OOP.D_InterfacesAndAbstraction.L02_CarShopExtend;

public class Audi implements Rentable{

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private Integer minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, int minRentDay, double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel(), getModel(), countryProduced, Car.TIRES);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }
}
