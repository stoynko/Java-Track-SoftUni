package F_DefiningClasses.L02_CarConstructors;

import java.util.*;

public class Main {

/*Make proper constructors for the Car class so you can create car objects with a different type of input information.
If you miss information about the field of type String set the value to "unknown", and for an integer, fieldset -1.

Read information about cars the same way as the previous task, however, this time uses constructors to create the objects,
not creating an object with the default constructor. You should be able to handle different types of input,
the format will be the same as the previous task, but this time some of the data may be missing.
For example, you can get only the car brand – which means you have to set the car model to "unknown" and the Horsepower value to -1.
There will be lines with complete car data, declare constructor which sets all the fields.
You have to add the car objects to a collection of your choice and print the data as in the previous task.
The input will always have one or three elements on each line.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            List<Car> carsList = new ArrayList<>();
            String[] carData = scanner.nextLine().split("\\s+");

            if (carData.length == 1) {
                String brand = carData[0];
                Car car = new Car(brand);
                carsList.add(car);
            } else {
                String brand = carData[0];
                String model = carData[1];
                int horsePower = Integer.parseInt(carData[2]);
                Car car = new Car(brand, model, horsePower);
                carsList.add(car);
            }
            carsList.forEach(System.out::println);
        }

    }
}
