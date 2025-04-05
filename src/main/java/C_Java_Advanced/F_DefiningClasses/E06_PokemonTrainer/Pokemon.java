package C_Java_Advanced.F_DefiningClasses.E06_PokemonTrainer;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
