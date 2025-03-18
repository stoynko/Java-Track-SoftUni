package D_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}