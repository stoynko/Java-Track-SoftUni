package D_OOP.X_Workshop.repositories;

import D_OOP.X_Workshop.entities.wallet.*;

import java.util.*;

public class WalletRepository implements Repository<Wallet, UUID> {

    private Map<UUID, Wallet> wallets;

    public WalletRepository() {
        this.wallets = new HashMap<>();
    }

    @Override
    public void save(UUID id, Wallet wallet) {
        this.wallets.put(id, wallet);
    }

    @Override
    public Wallet getById(UUID id) {
        return this.wallets.get(id);
    }

    @Override
    public List<Wallet> getAll() {
        return this.wallets.values().stream().toList();
    }
}
