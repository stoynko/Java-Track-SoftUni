package C_Advanced.F_DefiningClasses.L03_BankAccount;

import java.util.*;

public class Main {

/*Create class BankAccount. The class should have private fields for:

    •	Id: int (Starts from 1 and increments for every new account)
    •	Balance: double
    •	Interest rate: double (Shared for all accounts. Default value: 0.02)

The class should also have public methods for:
    •	setInterestRate(double interest): void (static)
    •	getInterest(int Years): double
    •	deposit(double amount): void

Create a test client supporting the following commands:
    •	Create
    •	Deposit {Id} {Amount}
    •	SetInterest {Interest}
    •	GetInterest {ID} {Years}
    •	End*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<BankAccount> bankAccounts = new ArrayList<>();

        while (!input.equals("End")) {

            String[] inputData = input.split(" ");

            switch (inputData[0]) {
                case "Create" -> {
                    BankAccount currentAccount = new BankAccount();
                    bankAccounts.add(currentAccount);
                    System.out.printf("Account ID%d created\n", currentAccount.getID());
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(inputData[1]);
                    double amount = Double.parseDouble(inputData[2]);
                    if (id - 1 > bankAccounts.size() - 1) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount bankAccount = bankAccounts.get(id - 1);
                        bankAccount.deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d\n", amount, id);
                    }
                }
                case "SetInterest" -> {
                    double interestRate = Double.parseDouble(inputData[1]);
                    BankAccount.setInterestRate(interestRate);
                }
                case "GetInterest" -> {
                    int id = Integer.parseInt(inputData[1]);
                    int years = Integer.parseInt(inputData[2]);
                    if (id - 1 > bankAccounts.size() - 1) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount bankAccount = bankAccounts.get(id - 1);
                        System.out.printf("%.2f\n", bankAccount.getInterest(years));
                    }
                }
            }
            input = scanner.nextLine();
        }
    }
}
