package D_OOP.D_InterfacesAndAbstraction.L04_SayHellloExtend;

public class European extends BasePerson {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
