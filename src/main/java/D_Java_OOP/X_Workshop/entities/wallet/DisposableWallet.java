package D_Java_OOP.X_Workshop.entities.wallet;

import java.math.*;
import java.util.*;

public class DisposableWallet extends Wallet {

    public static final int DISPOSABLE_WALLET_PERFORMED_WITHDRAWALS = 0;
    public static final int DISPOSABLE_WALLET_WITHDRAW_LIMIT = 2;
    public static final BigDecimal DISPOSABLE_WALLET_INITIAL_BALANCE = BigDecimal.ZERO;
    private int withdrawalsDone;

    public DisposableWallet(UUID id, UUID ownerId, String ownerUsername, Currency currency) {
        super(id, ownerId, ownerUsername, currency, DISPOSABLE_WALLET_INITIAL_BALANCE);
        this.withdrawalsDone = DISPOSABLE_WALLET_PERFORMED_WITHDRAWALS;
    }

    @Override
    public void withdraw(double amount) {
        if (this.withdrawalsDone == DISPOSABLE_WALLET_WITHDRAW_LIMIT) {
            setStatus(WalletStatus.INACTIVE);
        }
        super.withdraw(amount);
        this.withdrawalsDone++;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Wallet %s%s:", super.getId(), this.getClass().getSimpleName())).append(System.lineSeparator());
        output.append(String.format("Owner: %s", super.getOwnerUsername())).append(System.lineSeparator());
        output.append(String.format("Currency: %s", super.getCurrency())).append(System.lineSeparator());
        output.append(String.format("Balance: %.2f", super.getBalance())).append(System.lineSeparator());
        output.append(String.format("Status: %s", super.getStatus())).append(System.lineSeparator());
        output.append(String.format("Max withdrawals: %d", DISPOSABLE_WALLET_WITHDRAW_LIMIT)).append(System.lineSeparator());
        output.append(String.format("Current withdrawals: %d", withdrawalsDone)).append(System.lineSeparator());
        return output.toString().trim();
    }
}
