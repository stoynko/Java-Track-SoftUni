package D_Java_OOP.X_Workshop.entities.wallet;

import D_Java_OOP.X_Workshop.common.*;

import java.math.*;
import java.util.*;

public class DisposableWallet extends Wallet {

    public static final int DISPOSABLE_WALLET_PERFORMED_WITHDRAWALS = 0;
    public static final int DISPOSABLE_WALLET_WITHDRAW_LIMIT = 2;
    public static final BigDecimal DISPOSABLE_WALLET_INITIAL_BALANCE = BigDecimal.ZERO;
    private int withdrawalsDone;

    public DisposableWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, DISPOSABLE_WALLET_INITIAL_BALANCE);
        this.withdrawalsDone = DISPOSABLE_WALLET_PERFORMED_WITHDRAWALS;
    }

    @Override
    public void withdraw(double amount) {
        if (this.withdrawalsDone == DISPOSABLE_WALLET_WITHDRAW_LIMIT) {
            setStatus(WalletStatus.INACTIVE);
            throw new IllegalStateException(SystemErrors.WITHDRAWAL_LIMIT_REACHED_FOR_DISPOSABLE_WALLET);
        }
        super.withdraw(amount);
        this.withdrawalsDone++;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString()).append(System.lineSeparator());
        output.append("Max withdrawals: ").append(DISPOSABLE_WALLET_WITHDRAW_LIMIT).append(System.lineSeparator());
        output.append("Current withdrawals: ").append(withdrawalsDone).append(System.lineSeparator());
        return output.toString().trim();
    }
}
