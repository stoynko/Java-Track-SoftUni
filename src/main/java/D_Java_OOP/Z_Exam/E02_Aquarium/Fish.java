package D_Java_OOP.Z_Exam.E02_Aquarium;

public class Fish {

    private String name;
    private String habitat;
    private int speed;
    private boolean isEndangered;

    public Fish(String name, String habitat, int speed, boolean isEndangered) {
        this.name = name;
        this.habitat = habitat;
        this.speed = speed;
        this.isEndangered = isEndangered;
    }

    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public int getSpeed() {
        return speed;
    }

}

