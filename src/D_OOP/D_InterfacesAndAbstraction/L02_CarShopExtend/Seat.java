package D_OOP.D_InterfacesAndAbstraction.L02_CarShopExtend;

import D_OOP.D_InterfacesAndAbstraction.L01_CarShop.Car;

public class Seat implements Sellable {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;
    private double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
    }


    @Override
    public Double getPrice() {
        return this.price;
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

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel(), countryProduced(), Car.TIRES);
    }
}
