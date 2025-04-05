package C_Java_Advanced.H_IteratorsAndComparators.E06_StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        if (firstPerson.getName().length() == secondPerson.getName().length()) {
            char firstLetterFirstPerson = firstPerson.getName().toLowerCase().charAt(0);
            char firstLetterSecondPerson = secondPerson.getName().toLowerCase().charAt(0);

            return Character.compare(firstLetterFirstPerson, firstLetterSecondPerson);
        }
        return firstPerson.getName().length() - secondPerson.getName().length();
    }
}

