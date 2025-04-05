package D_Java_OOP.C_Inheritance.E06_Animals;

public class Kitten extends Cat {

    private static final String DEFAULT_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, DEFAULT_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
