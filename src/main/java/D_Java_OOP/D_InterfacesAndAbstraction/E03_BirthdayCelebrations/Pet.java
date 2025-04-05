package D_Java_OOP.D_InterfacesAndAbstraction.E03_BirthdayCelebrations;

public class Pet implements Birthable{

    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return this.birthdate;
    }
}
