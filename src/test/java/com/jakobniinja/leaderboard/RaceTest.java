package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RaceTest {

  private static final String NAME = "David";

  Driver driver1 = new Driver("Daniel", "Sweden");

  Driver driver2 = new Driver("Tomas", "England");

  @Test
  void onInit() {
    Race race = new Race(NAME, driver1, driver2);

    assertFalse(race.getResults().isEmpty());
  }

  @Test
  void onGetName() {
    Race race = new Race(NAME, driver1, driver2);
    assertEquals(NAME, race.toString());
  }

  @Test
  void onInitDriverNameNull() {
    Race race = new Race(NAME, driver1, driver2);
    assertNull(race.getDriversName(new Driver(NAME, "Sweden")));
  }

  @Test
  void onDriverNameDaniel() {
    Race race = new Race("Daniel", driver1, driver2);
    assertEquals("Daniel", race.getDriversName(new Driver("Daniel", "Sweden")));
  }
}
