package D_Java_OOP.D_InterfacesAndAbstraction.L04_SayHellloExtended;

public class European extends BasePerson {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
