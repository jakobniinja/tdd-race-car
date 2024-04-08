package com.jakobniinja.leaderboard;

import java.util.Collections;
import java.util.List;

public class LeaderBoard {

  private final List<Race> races;

  public LeaderBoard(Race race) {
    this.races = Collections.singletonList(race);
  }

  public List<Race> getRaces() {
    return races;
  }
}
