package D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.core.commands;

import D_Java_OOP.G_ReflectionsAndAnnotations.E05_BarracksWars_ReturnOfTheDependancies.interfaces.*;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
