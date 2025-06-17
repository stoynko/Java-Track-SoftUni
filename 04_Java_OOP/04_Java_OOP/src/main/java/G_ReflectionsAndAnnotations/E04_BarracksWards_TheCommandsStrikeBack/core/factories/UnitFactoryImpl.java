package G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.core.factories;

import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.Unit;
import G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.UnitFactory;

import java.lang.reflect.*;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = "D_OOP.G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.models.units.";

    @Override
    public Unit createUnit(String unitType){
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> unitConstructor = unitClass.getDeclaredConstructor();
            return unitConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
