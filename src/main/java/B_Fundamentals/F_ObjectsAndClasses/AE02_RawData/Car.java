package B_Fundamentals.F_ObjectsAndClasses.AE02_RawData;

import java.util.*;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tires> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tires> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public boolean searchByParameter(String parameter) {

        if (parameter.equals("fragile")) {
            String cargo = this.cargo.getCargoType();
            if (cargo.equals("fragile")) {
                for (Tires tire : tires) {
                    if (tire.getPressure() < 1) {
                        return true;
                    }
                }
            }

        } else if (parameter.equals("flamable")) {
            String cargo = this.cargo.getCargoType();
            if (cargo.equals("flamable") && this.engine.getEnginePower() > 250) {
                return true;
            }
        }
        return false;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getModel() {
        return this.model;
    }
}