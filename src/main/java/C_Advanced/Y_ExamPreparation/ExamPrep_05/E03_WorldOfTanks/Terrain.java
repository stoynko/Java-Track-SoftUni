package C_Advanced.Y_ExamPreparation.ExamPrep_05.E03_WorldOfTanks;

import java.util.*;
import java.util.stream.*;

public class Terrain {

    private String type;
    private int area;
    private List<Tank> tanks;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

    public String addTank(Tank tank) {
        for (Tank t : this.tanks) {
            if (tank.getBrand().equals(t.getBrand()) && tank.getModel().equals(t.getModel())) {
                return "Tank with this brand and model already exists!";
            }
        }
        if (this.type.equals("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        } else {
            this.tanks.add(tank);
            return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
        }
    }

    public boolean removeTank(String brand, String model) {
        for (Tank tank : this.tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                this.tanks.remove(tank);
                return true;
            }
        }
        return false;
    }

    public String getTanksByBarrelCaliberMoreThan (int barrelCaliber) {
        List<Tank> tanksMeetingCriteria = new ArrayList<>(this.tanks.stream()
                .filter(tank -> tank.getBarrelCaliber() > barrelCaliber)
                .collect(Collectors.toList()));

        if (!tanksMeetingCriteria.isEmpty()) {
            String output = tanksMeetingCriteria.stream().map(Tank::getBrand).collect(Collectors.joining(", "));
            return String.format("Tanks with caliber more than %dmm: %s", barrelCaliber, output);
        } else {
            return "There are no tanks with the specified caliber.";
        }
    }

    public Tank getTankByBrandAndModel (String brand, String model) {

        Tank tankToReturn = null;

        for (Tank tank : this.tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                tankToReturn = tank;
            }
        }

        return tankToReturn;
    }

    public String getTheMostArmoredTank() {
        if (!this.tanks.isEmpty()) {
            Tank mostArmored = this.tanks.stream().max(Comparator.comparing(Tank::getArmor)).get();
            return String.format("%s %s is the most armored tank with %dmm. armor thickness.", mostArmored.getBrand(),
                    mostArmored.getModel(),
                    mostArmored.getArmor());
        }
        return null;
    }


    public int getCount() {
        return this.tanks.size();
    }

    public String getStatistics() {
        if (!this.tanks.isEmpty()) {
            StringBuilder output = new StringBuilder();

            output.append(String.format("Tanks located in the %s:", this.type.toLowerCase()));
            this.tanks.forEach(tank -> {
                output.append(System.lineSeparator());
                output.append("-- " + tank.getBrand() + " " + tank.getModel());
            });

            return output.toString();
        } else {
            return String.format("There are no tanks in the %s.", this.type.toLowerCase());
        }
    }
}
