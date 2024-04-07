package com.jakobniinja.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

  private static final Integer[] POINTS = new Integer[]{1, 2, 4};

  private final String name;

  private List<Driver> results;

  private final Map<Driver, String> driversName;

  public Race(String name, Driver... drivers) {
    this.driversName = new HashMap<>();
    this.results = Arrays.asList(drivers);
    this.name = name;

    for (Driver driver : results) {
      String driverName = driver.getName();
      if (driver instanceof AutoPilot autoPilot) {
        driverName = String.format("Latest %s of model %s", autoPilot.getCountry(), autoPilot.getVersion());
      }
      driversName.put(driver, driverName);
    }
  }

  public List<Driver> getResults() {
    return results;
  }

  public String getDriversName(Driver driver) {
    return driversName.get(driver);
  }

  public int getPosition(Driver driver) {
    return results.indexOf(driver);
  }

  @Override
  public String toString() {
    return name;
  }

  public int getPoints(Driver driver) {
    int position = getPosition(driver);
    return POINTS[position];
  }
}

