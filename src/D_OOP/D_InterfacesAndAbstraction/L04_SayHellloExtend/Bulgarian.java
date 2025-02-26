package D_OOP.D_InterfacesAndAbstraction.L04_SayHellloExtend;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
