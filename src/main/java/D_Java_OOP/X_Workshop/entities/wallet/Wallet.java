package D_Java_OOP.X_Workshop.entities.wallet;

import D_Java_OOP.X_Workshop.common.*;

import java.math.*;
import java.util.*;

public abstract class Wallet {

    private UUID id;
    private UUID ownerId;
    private String ownerUsername;
    private Currency currency;
    private BigDecimal balance;
    private WalletStatus status;

    public Wallet(UUID ownerId, String ownerUsername, Currency currency, BigDecimal initialBalance) {
        this.id = UUID.randomUUID();
        this.ownerId = ownerId;
        this.ownerUsername = ownerUsername;
        this.currency = currency;
        this.balance = initialBalance;
        this.status = WalletStatus.ACTIVE;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalStateException(SystemErrors.TRANSACTION_INITIATED_WITH_INVALID_AMOUNT);
        }

        if (status == WalletStatus.INACTIVE) {
            throw new IllegalStateException(SystemErrors.NO_OPERATIONS_ALLOWED_FOR_NON_ACTIVE_WALLET);
        }

        BigDecimal bigDecimalAmount = BigDecimal.valueOf(amount);
        balance = balance.add(bigDecimalAmount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalStateException(SystemErrors.TRANSACTION_INITIATED_WITH_INVALID_AMOUNT);
        }

        if (status == WalletStatus.INACTIVE) {
            throw new IllegalStateException(SystemErrors.NO_OPERATIONS_ALLOWED_FOR_NON_ACTIVE_WALLET);
        }

        BigDecimal bigDecimalAmount = BigDecimal.valueOf(amount);

        if (bigDecimalAmount.compareTo(balance) > 0) {
            throw new IllegalStateException(SystemErrors.INSUFFICIENT_FUNDS_IN_WALLET);
        }

        balance = balance.subtract(bigDecimalAmount);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public WalletStatus getStatus() {
        return status;
    }

    public void setStatus(WalletStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Wallet [%s][%s]:".formatted(this.id, this.getClass().getSimpleName())).append(System.lineSeparator());
        output.append("Owner: ").append(this.ownerUsername).append(System.lineSeparator());
        output.append("Currency: ").append(this.currency).append(System.lineSeparator());
        output.append("Balance: ").append(this.balance).append(System.lineSeparator());
        output.append("Status: ").append(this.status).append(System.lineSeparator());
        return output.toString().trim();
    }
}
