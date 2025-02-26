package D_OOP.D_InterfacesAndAbstraction.L04_SayHellloExtend;

public class Chinese extends BasePerson {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
