package D_Java_OOP.D_InterfacesAndAbstraction.L03_SayHello;

public class European implements Person{

    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
