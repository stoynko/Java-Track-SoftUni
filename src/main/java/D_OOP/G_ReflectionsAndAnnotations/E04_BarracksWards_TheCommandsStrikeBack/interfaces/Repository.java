package D_OOP.G_ReflectionsAndAnnotations.E04_BarracksWards_TheCommandsStrikeBack.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType);
}
