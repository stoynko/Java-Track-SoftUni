package C_Java_Advanced.Z_Exam.E03_MajesticShips;

import java.util.*;
import java.util.stream.*;

public class Harbor {

    private String location;
    private int minDepth;
    private List<Ship> ships;

    public Harbor(String location, int minDepth) {
        this.location = location;
        this.minDepth = minDepth;
        this.ships = new ArrayList<>();
    }

    public String addShip(Ship ship) {
        for (Ship s : this.ships) {
            if (s.getName().equals(ship.getName())) {
                return "Ship with this name already exists!";
            }
        }
        if (ship.getDraft() > this.minDepth) {
            return String.format("The ship %s cannot dock due to draft limitations!", ship.getName());
        } else {
            this.ships.add(ship);
            return String.format("Ship %s added to the harbor.", ship.getName());
        }
    }

    public boolean removeShip(String name) {
        return this.ships.removeIf(ship -> ship.getName().equals(name));
    }

    public String getShipsByType(String type) {
        List<Ship> shipsByParam = this.ships.stream().filter(ships -> ships.getType().equals(type)).toList();
        if (shipsByParam.isEmpty()) {
            return "There are no ships of the requested type.";
        }
        String output = shipsByParam.stream().map(Ship::getName).collect(Collectors.joining(", "));
        return String.format("Ships of type %s: %s", type, output);
    }

    public Ship getShipByName(String name) {
        return this.ships.stream().filter(ship -> ship.getName().equals(name)).findFirst().orElse(null);
    }

    public String getLargestShip() {
        if (!this.ships.isEmpty()) {
            Ship largestShip = this.ships.stream().max(Comparator.comparing(Ship::getTonnage)).get();
            return String.format("%s is the largest ship with a tonnage of %d tons.", largestShip.getName(), largestShip.getTonnage());
        } else {
            return "No ships in the harbor.";
        }
    }

    public int getCount() {
        return this.ships.size();
    }

    public String getStatistics() {

        if (!this.ships.isEmpty()) {
            StringBuilder output = new StringBuilder();
            output.append(String.format("Ships docked in %s:", this.location));
            this.ships.forEach(ship -> {
                output.append(System.lineSeparator());
                output.append("* ").append(ship.getName());
            });
            return output.toString();
        } else {
            return String.format("No ships docked in %s.", this.location);
        }
    }
}


