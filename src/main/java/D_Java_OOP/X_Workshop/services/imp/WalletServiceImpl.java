package D_Java_OOP.X_Workshop.services.imp;

import D_Java_OOP.X_Workshop.common.*;
import D_Java_OOP.X_Workshop.core.*;
import D_Java_OOP.X_Workshop.entities.user.*;
import D_Java_OOP.X_Workshop.entities.wallet.*;
import D_Java_OOP.X_Workshop.repositories.*;
import D_Java_OOP.X_Workshop.services.WalletService;

import java.awt.*;
import java.util.Currency;
import java.util.List;
import java.util.UUID;
import java.util.stream.*;

public class WalletServiceImpl implements WalletService {

    private UserSessionManager sessionManager;
    private WalletRepository walletRepository;

    public WalletServiceImpl(UserSessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.walletRepository = new WalletRepository();
    }

    @Override
    public String createNewWallet(Currency currency, String walletType) {
        validateActiveSession();
        User currentActiveUser = sessionManager.getActiveSession();
        Wallet wallet = null;
        switch (WalletType.valueOf(walletType)) {
            case Standard -> {
                wallet = new StandardWallet(currentActiveUser.getId(), currentActiveUser.getUsername(), currency);
                if (walletRepository.getAll().stream()
                        .anyMatch(w -> w.getOwnerId().equals(currentActiveUser.getId())
                                && w instanceof StandardWallet)) {
                    throw new IllegalComponentStateException(SystemErrors.STANDARD_WALLET_COUNT_LIMIT_REACHED);
                }
            }
            case Savings -> wallet = new SavingsWallet(currentActiveUser.getId(), currentActiveUser.getUsername(), currency);
            case Disposable -> wallet = new DisposableWallet(currentActiveUser.getId(), currentActiveUser.getUsername(), currency);
            default -> throw new IllegalArgumentException(SystemErrors.INCORRECT_WALLET_TYPE);
        }
        walletRepository.save(wallet.getId(), wallet);
        return wallet.toString();
    }

    @Override
    public String getMyWallets() {
        validateActiveSession();
        User currentActiveUser = sessionManager.getActiveSession();
        List<Wallet> userWallets = walletRepository.getAll().stream().filter(w -> w.getId().equals(currentActiveUser.getId())).toList();
        return userWallets.stream().map(Wallet::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String deposit(UUID walletId, double amount) {
        return "";
    }

    @Override
    public String transfer(UUID walletId, String receiverUsername, double amount) {
        return "";
    }

    @Override
    public String changeWalletStatus(UUID walletId, String newStatus) {
        return "";
    }

    private void validateActiveSession() {
        if (!sessionManager.hasActiveSession()) {
            throw new IllegalStateException(SystemErrors.NO_ACTIVE_USER_SESSION_FOUND);
        }
    }
}
