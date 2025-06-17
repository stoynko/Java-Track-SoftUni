package F_DefiningClasses.L02_CarConstructors;

public class Car {

    private String brand;
    private String model;
    private int horsePower;


    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    
   public Car (String brand) {
        this.setBrand(brand);
        this.setModel("unknown");
        this.setHorsePower(-1);
   }

   public Car (String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
   }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsePower());
    }
}
