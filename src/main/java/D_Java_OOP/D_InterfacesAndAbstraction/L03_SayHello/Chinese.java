package D_Java_OOP.D_InterfacesAndAbstraction.L03_SayHello;

public class Chinese implements Person{

    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
