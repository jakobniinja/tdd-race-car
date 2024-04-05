package com.jakobniinja.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

  private final String name;

  public List<Driver> results;

  private final Map<Driver, String> driversName;

  public Race(String name, Driver... drivers) {
    this.driversName = new HashMap<>();
    this.results = Arrays.asList(drivers);
    this.name = name;

    for (Driver driver : results) {
      String driverName = driver.getName();
      driversName.put(driver, driverName);
    }
  }

  public List<Driver> getResults() {
    return results;
  }

  @Override
  public String toString() {
    return name;
  }

  public String getDriversName(Driver driver) {
    return this.driversName.get(driver);
  }
}

