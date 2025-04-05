package D_Java_OOP.C_Inheritance.E06_Animals;

public class Frog extends Animal {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
