package OOP.X_ExamPreparations.ExamPrep_07;

import D_OOP.Y_ExamPreparations.ExamPrep_07.E02_HandballTeams.*;
import org.junit.jupiter.api.*;
import java.util.*;

public class TeamTests {

    public static final String TEAM_VALID_NAME = "Blue";
    public static final String TEAM_INVALID_NAME = "";
    public static final String TEAM_NULL_NAME = null;
    public static final int VALID_POSITION_A = 2;
    public static final int VALID_POSITION_B = 3;
    public static final int INVALID_POSITION = -10;
    public static final String PLAYER_A_NAME = "Georgi";
    public static final String PLAYER_B_NAME = "Dimitar";
    public static final String PLAYER_C_NAME = "Petar";
    public static final String PLAYER_INVALID_NAME = "null";
    public static final String STATISTICS_OUTPUT = "The player %s is in the team %s.";

    Team team;
    HandballPlayer playerA;
    HandballPlayer playerB;
    HandballPlayer playerC;

    @BeforeEach
    public void init() {
        team = new Team(TEAM_VALID_NAME, VALID_POSITION_A);
        playerA = new HandballPlayer(PLAYER_A_NAME);
        playerB = new HandballPlayer(PLAYER_B_NAME);
        playerC = new HandballPlayer(PLAYER_C_NAME);
    }

    @Test
    public void SetNameMethodThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> new Team(TEAM_INVALID_NAME, VALID_POSITION_A));
        Assertions.assertThrows(NullPointerException.class, () -> new Team(TEAM_NULL_NAME, VALID_POSITION_A));
    }

    @Test
    public void SetPositionMethodThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Team(TEAM_VALID_NAME, INVALID_POSITION));
    }
    @Test
    public void GetNameMethodReturnsCorrectName() {
        Assertions.assertEquals(TEAM_VALID_NAME, team.getName());
    }

    @Test
    public void GetPositionMethodReturnsCorrectPosition() {
        Assertions.assertEquals(VALID_POSITION_A, team.getPosition());
        Assertions.assertNotEquals(VALID_POSITION_B, team.getPosition());
    }

    @Test
    public void GetCountMethodReturnsCorrectVal() {
        int initialCount = 0;
        Assertions.assertEquals(initialCount, team.getCount());
        team.add(playerA);
        Assertions.assertEquals(initialCount + 1, team.getCount());
        team.add(playerB);
        Assertions.assertEquals(initialCount + 2, team.getCount());
    }

    @Test
    public void AddMethodThrowsIllegalArgumentExceptionWhenAtCapacity() {
        team.add(playerA);
        team.add(playerB);
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.add(playerC) );
    }

    @Test
    public void RemoveMethodThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.remove(PLAYER_INVALID_NAME));
    }

    @Test
    public void RemoveMethodCorrectlyRemovesPlayerByName() {
        team.add(playerA);
        team.add(playerB);
        int playersCount = team.getCount();
        team.remove(PLAYER_A_NAME);
        Assertions.assertEquals(playersCount - 1, team.getCount());
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.remove(PLAYER_A_NAME));
    }

    @Test
    public void PlayerForAnotherTeamThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> team.playerForAnotherTeam(PLAYER_INVALID_NAME));
    }

    @Test
    public void PlayerForAnotherTeamCorrectlyReturnsPlayerAndDeactivates() {
        team.add(playerA);
        Assertions.assertSame(playerA, team.playerForAnotherTeam(PLAYER_A_NAME));
        Assertions.assertFalse(playerA.isActive());
    }

    @Test
    public void GetStatisticsMethodReturnsString() {
        team.add(playerA);
        team.add(playerB);
        List<String> playerNames = Arrays.asList(PLAYER_A_NAME, PLAYER_B_NAME);
        String players = String.join(", ", playerNames);
        Assertions.assertEquals(String.format(STATISTICS_OUTPUT, players, TEAM_VALID_NAME), team.getStatistics());
    }
}