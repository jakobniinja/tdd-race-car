package com.jakobniinja.leaderboard;

import java.util.Arrays;
import java.util.List;

public class Race {

  private final String name;

  public List<Driver> results;

  public Race(String name, Driver... drivers) {
    this.name = name;
    this.results = Arrays.asList(drivers);
  }

  public List<Driver> getResults() {
    return results;
  }

  @Override
  public String toString() {
    return name;
  }
}

