package D_Java_OOP.X_Workshop.entities.wallet;

import D_Java_OOP.X_Workshop.common.*;

import java.math.*;
import java.time.*;
import java.util.*;

public class SavingsWallet extends Wallet {

    public static final BigDecimal SAVINGS_WALLET_INITIAL_BALANCE = BigDecimal.valueOf(10);
    public static final long DEFAULT_SAVING_PERIOD = 2;

    LocalDateTime savingPeriodEnd;

    public SavingsWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, SAVINGS_WALLET_INITIAL_BALANCE);
        this.savingPeriodEnd = LocalDateTime.now().plusMinutes(DEFAULT_SAVING_PERIOD);
    }

    public long getSecondsLeftOfPeriod() {
        return Duration.between(LocalDateTime.now(), savingPeriodEnd).toSeconds();
    }

    @Override
    public void withdraw(double amount) {
        if (LocalDateTime.now().isBefore(savingPeriodEnd)) {
            throw new IllegalStateException(SystemErrors.SAVINGS_PERIOD_NOT_CONCLUDED_YET.formatted(getSecondsLeftOfPeriod()));
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString()).append(System.lineSeparator());
        output.append("Saving period ends within: ").append(getSecondsLeftOfPeriod()).append(" seconds").append(System.lineSeparator());
        return output.toString().trim();
    }
}
