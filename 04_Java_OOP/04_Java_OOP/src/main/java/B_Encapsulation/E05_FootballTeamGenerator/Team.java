package B_Encapsulation.E05_FootballTeamGenerator;

import java.util.*;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {

        Player currentPlayer = this.players.stream().filter(p -> p.getName().equals(player)).findFirst().orElse(null);
        if (currentPlayer != null) {
            this.players.remove(currentPlayer);
        } else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }
    }

    public double getRating() {
        if (this.players.isEmpty()) {
            return 0;
        }
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum() / this.players.size();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>();
    }
}
