package D_OOP.A_WorkingWithAbstraction.L04_HotelReservation;

public enum Discount {

    VIP(0.2),
    SecondVisit(0.1),
    None(0);

    private double percentage;

    Discount(double multiplier) {
        this.percentage = multiplier;
    }

    public double getPercentage() {
        return percentage;
    }
}
