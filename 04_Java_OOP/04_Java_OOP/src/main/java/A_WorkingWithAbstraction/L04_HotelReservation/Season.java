package A_WorkingWithAbstraction.L04_HotelReservation;

public enum Season {

    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
