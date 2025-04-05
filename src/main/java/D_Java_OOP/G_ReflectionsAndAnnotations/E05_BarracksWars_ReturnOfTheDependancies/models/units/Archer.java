package D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.models.units;

public class Archer extends AbstractUnit {
    private static final int ARCHER_HEALTH = 25;
    private static final int ARCHER_DAMAGE = 7;

    public Archer() {
        super(ARCHER_HEALTH, ARCHER_DAMAGE);
    }
}
