package C_Advanced.F_DefiningClasses.L01_CarInfo;

import java.util.*;

public class Main {

/*Create a class named Car. The class should have public fields for:
    •	Brand: String
    •	Model: String
    •	Horsepower: int
Create a new class and ensure proper naming. This method should return the info about any car object in the following format:

"The car is: {brand} {model} – {horsePower} HP."*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            String[] carData = scanner.nextLine().split("\\s+");
            String brand = carData[0];
            String model = carData[1];
            int horsePower = Integer.parseInt(carData[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);


            System.out.println(car);
        }

    }
}
