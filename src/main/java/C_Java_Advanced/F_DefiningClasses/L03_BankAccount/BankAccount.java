package C_Java_Advanced.F_DefiningClasses.L03_BankAccount;

public class BankAccount {

    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static int bankAccountsCount = 1;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountsCount++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public int getID() {
        return this.id;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
