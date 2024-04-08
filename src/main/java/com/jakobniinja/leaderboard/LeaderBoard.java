package com.jakobniinja.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderBoard {

  private final List<Race> races;

  public LeaderBoard(Race... race) {
    this.races = Arrays.asList(race);
  }

  public List<Race> getRaces() {
    return races;
  }

  public Map<String, Integer> results() {

    HashMap<String, Integer> results = new HashMap<>();
    for (Race race : races) {
      for (Driver driver : race.getResults()) {
        String name = race.getDriversName(driver);
        int points = race.getPoints(driver);
        results.put(name, results.getOrDefault(name, 0) + points);
      }
    }
    return results;
  }
}
