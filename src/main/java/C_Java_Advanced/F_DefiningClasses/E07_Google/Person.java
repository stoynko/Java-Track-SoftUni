package C_Java_Advanced.F_DefiningClasses.E07_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String personName;
    private Car car;
    private Company company;
    private List<Child> childrenList;
    private List<Parent> parentsList;
    private List<Pokemon> pokemonsList;

    public Person(String personName, Car car, Company company, List<Child> childrenList, List<Parent> parentsList, List<Pokemon> pokemonsList) {
        this.car = car;
        this.company = company;
        this.childrenList = childrenList;
        this.parentsList = parentsList;
        this.pokemonsList = pokemonsList;
    }

    public Person(String personName) {
        this.personName = personName;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonsList = new ArrayList<>();
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public List<Parent> getParentsList() {
        return parentsList;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();

        output.append(personName);
        output.append(System.lineSeparator());
        output.append("Company:").append(System.lineSeparator());
        if (company != null) {
            output.append(company);
            output.append(System.lineSeparator());
        }
        output.append("Car:").append(System.lineSeparator());
        if (car != null) {
            output.append(car);
            output.append(System.lineSeparator());
        }
        output.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonsList) {
            output.append(pokemon).append(System.lineSeparator());
        }
        output.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parentsList) {
            output.append(parent).append(System.lineSeparator());
        }
        output.append("Children:").append(System.lineSeparator());
        for (Child child : childrenList) {
            output.append(child).append(System.lineSeparator());
        }
        return output.toString();
    }
}
