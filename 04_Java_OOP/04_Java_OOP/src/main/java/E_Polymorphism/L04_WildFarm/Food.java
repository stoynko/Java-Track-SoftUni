package E_Polymorphism.L04_WildFarm;

public abstract class Food {

    private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
