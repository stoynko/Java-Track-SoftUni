package C_Advanced.F_DefiningClasses.E04_RawData;

public class Engine {

    private int engineSpeed;
    private int enginePower;

    Engine (int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }
    public int getEnginePower() {
        return enginePower;
    }
}
