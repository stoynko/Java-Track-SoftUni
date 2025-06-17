package X_Workshop.entities.wallet;

import java.math.*;
import java.util.*;

public class StandardWallet extends Wallet {

    public static final BigDecimal STANDARD_WALLET_INITIAL_BALANCE = BigDecimal.valueOf(20);

    public StandardWallet(UUID ownerId, String ownerUsername, Currency currency) {
        super(ownerId, ownerUsername, currency, STANDARD_WALLET_INITIAL_BALANCE);
    }
}
