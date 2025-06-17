package F_DefiningClasses.E04_RawData;

public class Tires {


    private double pressure;
    private int age;

    public Tires (double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public int getAge() {
        return age;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
