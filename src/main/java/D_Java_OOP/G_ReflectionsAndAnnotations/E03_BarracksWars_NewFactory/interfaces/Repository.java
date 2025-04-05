package D_Java_OOP.G_ReflectionsAndAnnotations.E03_BarracksWars_NewFactory.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
