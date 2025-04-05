package B_Java_Fundamentals.F_ObjectsAndClasses.E05_VehicleCatalogue;

public class Vehicles {

    private String vehicleType;
    private String model;
    private String color;
    private int horsePower;

    public Vehicles(String vehicleType, String model, String color, int horsePower) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
