package D_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.team;

import D_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.common.*;

public class BaseTeam implements Team {

    public static final int BASE_ADVANTAGE = 0;

    private String name;
    private String country;
    private int advantage;

    public BaseTeam(String name, String country, int advantage) {
        setName(name);
        setCountry(country);
        setAdvantage(advantage);
    }

    @Override
    public void play() {
        this.advantage += BASE_ADVANTAGE;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.TEAM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setCountry(String country) {
        if (country == null || country.isBlank()) {
            throw new NullPointerException(ExceptionMessages.TEAM_COUNTRY_NULL_OR_EMPTY);
        }
        this.country = country;
    }

    public void setAdvantage(int advantage) {
        if (advantage <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }
        this.advantage = advantage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAdvantage() {
        return this.advantage;
    }
}
