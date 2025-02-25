package D_OOP.D_InterfacesAndAbstraction.L02_CarShopExtend;

public interface Rentable extends CarImpl{

    int getMinRentDay();
    double getPricePerDay();
}
