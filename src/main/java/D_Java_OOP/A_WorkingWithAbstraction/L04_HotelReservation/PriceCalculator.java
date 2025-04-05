package D_Java_OOP.A_WorkingWithAbstraction.L04_HotelReservation;

public class PriceCalculator {

    public static double calculate(double pricePerDay, int days, Season season, Discount discount) {
        double subTotal = days * pricePerDay * season.getMultiplier();
        return subTotal - (subTotal * discount.getPercentage());
    }
}
