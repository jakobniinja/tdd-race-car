package com.jakobniinja.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

  public List<String> getRanking() {
    Map<String, Integer> results = results();

    List<String> list = new ArrayList<>(results.keySet());
    list.sort(new NameComparator(results));

    return list;
  }
}
