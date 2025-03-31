package D_OOP.X_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.pickers;

public class ExperiencedPicker extends BasePicker {

    public static final int EXPERIENCED_PICKER_INITIAL_VITALITY = 60;

    public ExperiencedPicker(String name) {
        super(name, EXPERIENCED_PICKER_INITIAL_VITALITY);
    }
}
