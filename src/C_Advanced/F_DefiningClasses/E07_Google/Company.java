package C_Advanced.F_DefiningClasses.E07_Google;

public class Company {

    private String companyName;
    private String companyDepartment;
    private double salary;

    public Company (String companyName, String companyDepartment, double salary) {
        this.companyName = companyName;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    @Override
    public String toString () {

        return companyName + " " + companyDepartment + " " + String.format("%.2f", salary);
    }
}
