package D_Java_OOP.D_InterfacesAndAbstraction.L04_SayHellloExtended;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
