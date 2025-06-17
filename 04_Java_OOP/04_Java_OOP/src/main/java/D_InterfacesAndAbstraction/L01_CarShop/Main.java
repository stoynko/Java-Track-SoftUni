package D_InterfacesAndAbstraction.L01_CarShop;

public class Main {

//Build hierarchy from classes and interfaces

    public static void main(String[] args) {

        Car seat = new Seat("Leon", "gray", 110, "Spain");

        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                seat.getModel(),
                seat.getColor(),
                seat.getHorsePower()));
        System.out.println(seat.toString());
    }
}