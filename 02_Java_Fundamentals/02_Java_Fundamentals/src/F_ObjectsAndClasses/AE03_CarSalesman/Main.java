package F_ObjectsAndClasses.AE03_CarSalesman;

import java.util.*;

public class Main {

/*Define two classes Car and Engine. A Car has a model, engine, weight, and color. An Engine has a model,
power, displacement, and efficiency. A Car's weight and color and its Engine's displacements and efficiency are optional.
On the first line, you will read a number N which will specify how many lines of engines you will receive, on each of the next N lines,
you will receive information about an Engine in the following format "{Model} {Power} {Displacement} {Efficiency}".
After the lines with engines, on the next line, you will receive a number M – specifying the number of Cars that will follow,
on each of the next M lines, information about a Car will follow in the following format "{Model} {Engine} {Weight} {Color}",
where the engine in the format will be the model of an existing Engine. When creating the object for a Car,
you should keep a reference to the real engine in it, instead of just the engine's model, note that the optional properties might be missing
from the formats. Your task is to print each car (in the order you received them) and its information in the format defined below,
if any of the optional fields have not been given, print "n/a" in its place instead:

"{CarModel}:
  {EngineModel}:
    Power: {EnginePower}
    Displacement: {EngineDisplacement}
    Efficiency: {EngineEfficiency}
  Weight: {CarWeight}
  Color: {CarColor}"

Optional
    •   Override the classes' ToString() methods to have a reusable way of displaying the objects. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Engine> enginesList = new ArrayList<>();
        int engineEntries = Integer.parseInt(scanner.nextLine());

        for (int currentEntry = 1; currentEntry <= engineEntries; currentEntry++) {

            String[] engineData = scanner.nextLine().split(" ");
            Engine currentEngine = getEngine(engineData);
            enginesList.add(currentEngine);
        }

        int carEntries = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int currentEntry = 1; currentEntry <= carEntries; currentEntry++) {

            String[] carData = scanner.nextLine().split(" ");
            Car currentCar = getCar(carData, enginesList);
            carsList.add(currentCar);
        }

        carsList.forEach(System.out::print);
    }

    private static Car getCar(String[] carData, List<Engine> enginesList) {

        String model = carData[0];
        String engine = carData[1];

        int index = 0;
        while (true) {
            String engineModel = enginesList.get(index).getModel();
            if (engineModel.equals(engine)) {
                break;
            }
            index++;
        }

        Engine currentEngine = enginesList.get(index);
        String weight = "n/a";
        String color = "n/a";

        if (carData.length == 3) {
            String data = carData[2];
            if (Character.isDigit(data.charAt(0))) {
                weight = data;
            } else if (Character.isLetter(data.charAt(0))) {
                color = data;
            }
        } else if (carData.length == 4) {
            String data = carData[2];
            if (Character.isDigit(data.charAt(0))) {
                weight = data;
                color = carData[3];
            } else if (Character.isLetter(data.charAt(0))) {
                color = data;
                weight = carData[3];
            }
        }
        return new Car(model, currentEngine, weight, color);
    }

    private static Engine getEngine(String[] engineData) {

        String model = engineData[0];
        int power = Integer.parseInt(engineData[1]);
        String displacement = "n/a";
        String efficiency = "n/a";

        if (engineData.length == 3) {
            String data = engineData[2];
            if (Character.isDigit(data.charAt(0))) {
                displacement = data;
            } else if (Character.isLetter(data.charAt(0))) {
                efficiency = data;
            }
        } else if (engineData.length == 4) {
            String data = engineData[2];
            if (Character.isDigit(data.charAt(0))) {
                displacement = data;
                efficiency = engineData[3];
            } else if (Character.isLetter(data.charAt(0))) {
                efficiency = data;
                displacement = engineData[3];
            }
        }
        return new Engine(model, power, displacement, efficiency);
    }
}
