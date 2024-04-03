package com.jakobniinja.leaderboard;

import java.util.Objects;

public class Driver {

  private final String name;

  private final String country;

  public Driver(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }


  public String getCountry() {
    return country;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, country);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Driver driver = (Driver) o;
    return Objects.equals(name, driver.name) && Objects.equals(country, driver.country);
  }
}
