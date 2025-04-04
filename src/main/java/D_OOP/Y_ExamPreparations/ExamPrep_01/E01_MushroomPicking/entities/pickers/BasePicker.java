package D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers;

import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.common.ExceptionMessages;
import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.bag.Bag;
import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.bag.BagImpl;

public class BasePicker implements Picker {

    private String name;
    private int vitality;
    private Bag bag;

    public BasePicker(String name, int vitality) {
        setName(name);
        setVitality(vitality);
        this.bag = new BagImpl();
    }

    public void setName(String name) {
       if (name == null || name.isBlank()) {
           throw new IllegalArgumentException(ExceptionMessages.PICKER_NAME_NULL_OR_EMPTY);
       }
    }

    public void setVitality(int vitality) {
        if (vitality < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PICKER_VITALITY_LESS_THAN_ZERO);
        }
        this.vitality = vitality;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void pick() {
        this.vitality -= 10;
        if (this.vitality < 0) {
            this.vitality = 0;
        }
    }
}
