package X_Workshop.services.imp;

import D_Java_OOP.X_Workshop.common.*;
import D_Java_OOP.X_Workshop.core.*;
import D_Java_OOP.X_Workshop.entities.user.*;
import D_Java_OOP.X_Workshop.entities.wallet.*;
import D_Java_OOP.X_Workshop.repositories.*;
import X_Workshop.services.WalletService;

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
            case Savings ->
                    wallet = new SavingsWallet(currentActiveUser.getId(), currentActiveUser.getUsername(), currency);
            case Disposable ->
                    wallet = new DisposableWallet(currentActiveUser.getId(), currentActiveUser.getUsername(), currency);
            default -> throw new IllegalArgumentException(SystemErrors.INCORRECT_WALLET_TYPE);
        }
        walletRepository.save(wallet.getId(), wallet);
        return wallet.toString();
    }

    @Override
    public String getMyWallets() {
        validateActiveSession();
        User currentActiveUser = sessionManager.getActiveSession();
        List<Wallet> userWallets = walletRepository.getAll().stream().filter(w -> w.getOwnerId().equals(currentActiveUser.getId())).toList();
        if (userWallets.isEmpty()) {
            throw new IllegalStateException(LogMessages.ZERO_WALLETS);
        }
        String separator = System.lineSeparator() + "-----------------------" + System.lineSeparator();
        return userWallets.stream().map(Wallet::toString).collect(Collectors.joining(separator));
    }

    @Override
    public String deposit(UUID walletId, double amount) {
        Wallet wallet = getCurrentActiveUserWallet(walletId);
        wallet.deposit(amount);
        return LogMessages.SUCCESSFULLY_DEPOSITED_AMOUNT.formatted(wallet.getBalance(), wallet.getCurrency());
    }

    @Override
    public String transfer(UUID walletId, String recipientUsername, double amount) {

        Wallet walletSender = getCurrentActiveUserWallet(walletId);
        Wallet walletRecipient = walletRepository.getAll().stream()
                .filter(w -> w.getOwnerUsername().equals(recipientUsername) && w instanceof StandardWallet)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(SystemErrors.NO_WALLET_FOUND_FOR_RECEIVER.formatted(recipientUsername)));


        boolean isSenderWalletActive = walletSender.getStatus() == WalletStatus.ACTIVE;
        boolean isRecipientWalletActive = walletRecipient.getStatus() == WalletStatus.ACTIVE;
        boolean isCurrencySame = walletSender.getCurrency().equals(walletRecipient.getCurrency());

        if (isSenderWalletActive && isRecipientWalletActive && isCurrencySame) {
            walletSender.withdraw(amount);
            walletRecipient.deposit(amount);
        } else {
            throw new IllegalStateException(SystemErrors.TRANSFER_CRITERIA_NOT_MET);
        }

        return LogMessages.SUCCESSFUL_FUNDS_TRANSFER.formatted(walletSender.getOwnerUsername(), amount, recipientUsername, walletSender.getBalance());
    }


    @Override
    public String changeWalletStatus(UUID walletId, String status) {

        WalletStatus newStatus;
        try {
            newStatus = WalletStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(SystemErrors.INCORRECT_WALLET_STATUS);
        }
        Wallet wallet = getCurrentActiveUserWallet(walletId);
        wallet.setStatus(newStatus);
        return LogMessages.SUCCESSFULLY_CHANGED_WALLET_STATUS.formatted(newStatus);
    }

    private void validateActiveSession() {
        if (!sessionManager.hasActiveSession()) {
            throw new IllegalStateException(SystemErrors.NO_ACTIVE_USER_SESSION_FOUND);
        }
    }

    private Wallet getCurrentActiveUserWallet(UUID walletId) {
        User currentActiveUser = sessionManager.getActiveSession();
        return walletRepository.getAll().stream()
                .filter(w -> w.getId().equals(walletId) && w.getOwnerId().equals(currentActiveUser.getId()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(SystemErrors.WALLET_NOT_ASSOCIATED_WITH_THIS_USER.formatted(currentActiveUser.getUsername())));
    }
}

