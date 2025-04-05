package D_OOP.X_Workshop.entities.wallet;

import D_OOP.X_Workshop.entities.user.*;

import java.math.*;
import java.util.*;

public class Wallet {

    private UUID id;
    private UUID ownerId;
    private String ownerUsername;
    private Currency currency;
    private BigDecimal balance;
    private WalletStatus status;

    public Wallet(UUID id, UUID ownerId, String ownerUsername, Currency currency, BigDecimal balance) {
        this.id = id;
        this.ownerId = ownerId;
        this.ownerUsername = ownerUsername;
        this.currency = currency;
        this.balance = balance;
        this.status = WalletStatus.ACTIVE;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public WalletStatus getStatus() {
        return status;
    }
}
