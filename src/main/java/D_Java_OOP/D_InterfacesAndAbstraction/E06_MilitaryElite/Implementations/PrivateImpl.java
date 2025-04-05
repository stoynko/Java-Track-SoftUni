package D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Implementations;

import D_Java_OOP.D_InterfacesAndAbstraction.E06_MilitaryElite.Interfaces.*;

public class PrivateImpl extends SoldierImpl implements Private, Comparable<Private> {

    private double salary;

    public PrivateImpl(String firstName, String lastName, int id, double salary) {
        super(firstName, lastName, id);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f", super.getFirstName(), super.getLastName(), super.getId(), this.salary);
    }

    @Override
    public int compareTo(Private p) {
        if (this.getId() == p.getId()) {
            return 0;
        } else if (this.getId() > p.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}

