package D_Java_OOP.X_Workshop.core;

import D_Java_OOP.X_Workshop.services.WalletService;
import D_Java_OOP.X_Workshop.services.UserService;
import D_Java_OOP.X_Workshop.services.imp.*;

import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;
import java.util.UUID;

public class Engine implements Runnable {

    private Scanner scanner;
    private UserSessionManager sessionManager;
    private UserService userService;
    private WalletService walletService;

    public Engine() {
        this.scanner = new Scanner(System.in);
         this.sessionManager = new UserSessionManager();
         this.userService = new UserServiceImpl(this.sessionManager);
         this.walletService = new WalletServiceImpl(this.sessionManager);
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Welcome to Smart Wallet!");
        System.out.println("------------------------");
        System.out.println("Possible commands:");
        System.out.println("1. Register | username | password |");
        System.out.println("2. Login | username | password |");
        System.out.println("3. Logout");
        System.out.println("4. NewWallet | currency | type");
        System.out.println("5. Deposit | id | amount");
        System.out.println("6. MyWallets");
        System.out.println("7. ChangeWalletStatus | id | status");
        System.out.println("8. Transfer | walletId | recipientUsername | amount");
        System.out.println("9. Exit");
        System.out.println("------------------------");
        while (true) {
            String result;
            try {
                result = processInput();
                if (result.equals("Exit")) {
                    break;
                }
                System.out.println("\033[0;34m" + result + "\033[0m");
            } catch (Exception e) {
                result = e.getMessage();
                System.err.println(result);
            }
        }
    }

    private String processInput() {

        String result = null;

        String[] tokens = scanner.nextLine().split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);


        switch (command) {
            case Login:
                result = userService.login(data[0], data[1]);
                break;
            case Register:
                result = userService.register(data[0], data[1]);
                break;
            case Logout:
                result = userService.logout();
                break;
            case NewWallet:
                result = walletService.createNewWallet(Currency.getInstance(data[0]), data[1]);
                break;
            case MyWallets:
                result = walletService.getMyWallets();
                break;
            case ChangeWalletStatus:
                result = walletService.changeWalletStatus(UUID.fromString(data[0]), data[1]);
                break;
            case Deposit:
                result = walletService.deposit(UUID.fromString(data[0]), Double.parseDouble(data[1]));
                break;
            case Transfer:
                result = walletService.transfer(UUID.fromString(data[0]), data[1], Double.parseDouble(data[2]));
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
}
