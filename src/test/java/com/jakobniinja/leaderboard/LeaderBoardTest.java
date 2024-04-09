package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeaderBoardTest {

  private LeaderBoard leaderBoard;

  private Race race;


  @BeforeEach
  void setUp() {
    race = new Race("Grand-Tour", new Driver("David", "Sweden"));
    leaderBoard = new LeaderBoard(race);
  }

  @Test
  void onAddRaceNotEmpty() {
    assertFalse(leaderBoard.getRaces().isEmpty());
  }

  @Test
  void onGetEmptyRace() {
    assertFalse(leaderBoard.getRaces().isEmpty());
  }

  @Test
  void onInitLeaderBoardNotNull() {
    assertEquals(1, leaderBoard.getRaces().size());
  }

  @Test
  void onDisplayLeaderboardTwoRaces() {
    LeaderBoard leaderBoard = new LeaderBoard(race, race);
    assertEquals(2, leaderBoard.getRaces().size());
  }

  @Test
  void onDriverNoResult() {
    Map<String, Integer> results = leaderBoard.results();
    assertEquals(1, results.size());
  }

  @Test
  void onFirstDriver1Point() {
    Map<String, Integer> results = leaderBoard.results();
    assertTrue(results.containsValue(1));
  }

  @Test
  void onGetDriverRanking() {
    assertFalse(leaderBoard.getRanking().isEmpty());
  }


  @Test
  void onVerifyInsertionOrder() {
    race = new Race("Grand-Tour", new Driver("David", "Sweden"), new Driver("Adam", "Sweden"));

    assertTrue(leaderBoard.getRanking().get(0).equalsIgnoreCase("David"));
    assertFalse(leaderBoard.getRanking().isEmpty());
  }


  @Test
  void onImplComparatorForName() {
    race = new Race("Grand-Tour", new Driver("David B", "Sweden"), new Driver("David A", "Sweden"));
    leaderBoard = new LeaderBoard(race);

    assertTrue(leaderBoard.getRanking().get(0).equalsIgnoreCase("David A"));
    assertFalse(leaderBoard.getRanking().isEmpty());
  }
}
