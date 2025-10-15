package main.model;

public enum PlayerClass {

    MYSTIC_MUSE("Mystic Muse"),
    GHOST_HUNTER("Ghost Hunter"),
    DOOMBRINGER("Doombringer");

    private final String playerClass;

    PlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerClass() {
        return playerClass;
    }
}