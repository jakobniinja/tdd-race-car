package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LeaderBoardTest {

  @Test
  void onInit() {
    Race race = new Race("Grand-Tour", new Driver("David", "Sweden"));
    assertNotNull(new LeaderBoard(race));
  }

  @Test
  void onAddRaceNotEmpty() {
    Race race = new Race("Grand-Tour", new Driver("David", "Sweden"));
    LeaderBoard leaderBoard = new LeaderBoard(race);

    assertFalse(leaderBoard.getRaces().isEmpty());
  }

  @Test
  void onGetEmptyRace() {
    Race race = new Race("best race", new Driver("David", "Sweden"));
    assertFalse(new LeaderBoard(race).getRaces().isEmpty());
  }

  @Test
  void onInitLeaderBoardNotNull() {
    Race race = new Race("best race", new Driver("David", "Sweden"));

    LeaderBoard leaderBoard = new LeaderBoard(race);

    assertEquals(1, leaderBoard.getRaces().size());
  }
}
