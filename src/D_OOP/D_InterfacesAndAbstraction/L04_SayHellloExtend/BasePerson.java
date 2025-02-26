package D_OOP.D_InterfacesAndAbstraction.L04_SayHellloExtend;

public abstract class BasePerson implements Person{

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
