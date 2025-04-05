package B_Java_Fundamentals.F_ObjectsAndClasses.E05_VehicleCatalogue;

import java.util.*;

public class Main {

/*You have to make a catalog for vehicles. You will receive two types of vehicles - a car or a truck.
Until you receive the command "End" you will receive lines of input in the format:
"{typeOfVehicle} {model} {color} {horsepower}"
After the "End" command, you will start receiving models of vehicles. Print for every received vehicle its data in the format:

Type: {typeOfVehicle}
Model: {modelOfVehicle}
Color: {colorOfVehicle}
Horsepower: {horsepowerOfVehicle}

When you receive the command "Close the Catalogue",
stop receiving input and print the average horsepower for the cars and the trucks in the format:
"{typeOfVehicles} have average horsepower of {averageHorsepower}."
The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by the
total count of vehicles from the same type. Format the answer to the 2nd decimal point.

Constraints:
•	The type of vehicle will always be a car or truck.
•	You will not receive the same model twice.
•	The received horsepower will be an integer in the interval [1…1000].
•	You will receive at most 50 vehicles.
•	Single whitespace will be used for the separator.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Vehicles> carList = new ArrayList<>();
        List<Vehicles> truckList = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] vehicleData = input.split(" ");
            String typeOfVehicle = vehicleData[0];
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsePower = Integer.parseInt(vehicleData[3]);

            Vehicles currentVehicle = new Vehicles(typeOfVehicle, model, color, horsePower);
            switch (typeOfVehicle) {
                case "car" -> carList.add(currentVehicle);
                case "truck" -> truckList.add(currentVehicle);
            }
            input = scanner.nextLine();
        }

        String searchParameter = scanner.nextLine();
        while (!searchParameter.equals("Close the Catalogue")) {
            int currentVehicleIndex;
            String finalSearchParameter = searchParameter;
            Vehicles foundVehicle = carList.stream().filter(vehicle -> vehicle.getModel().equals(finalSearchParameter)).findFirst().orElse(null);
            if (foundVehicle != null) {
                printVehicleData(foundVehicle);
            } else {
                foundVehicle = truckList.stream().filter(vehicle -> vehicle.getModel().equals(finalSearchParameter)).findFirst().orElse(null);
                if (foundVehicle != null) {
                    printVehicleData(foundVehicle);
                }
            }
            searchParameter = scanner.nextLine();
        }
        String type = "Cars";
        printAverageHP(carList, type);
        type = "Trucks";
        printAverageHP(truckList, type);
    }

    public static void printVehicleData(Vehicles vehicle) {
        if (vehicle.getVehicleType().equals("car")) {
            System.out.println("Type: Car");
        } else {
            System.out.println("Type: Truck");
        }
        System.out.printf("Model: %s%n", vehicle.getModel());
        System.out.printf("Color: %s%n", vehicle.getColor());
        System.out.printf("Horsepower: %d%n", vehicle.getHorsePower());
    }

    public static void printAverageHP(List<Vehicles> list, String type) {
        if (!list.isEmpty()) {
            int sumHorsePower = 0;
            for (Vehicles vehicle : list) {
                sumHorsePower += vehicle.getHorsePower();
            }
            double averageHorsePower = (double) sumHorsePower / list.size();
            System.out.printf("%s have average horsepower of: %.2f.%n", type, averageHorsePower);
        } else {
            System.out.printf("%s have average horsepower of: 0.00.%n", type);
        }
    }
}
