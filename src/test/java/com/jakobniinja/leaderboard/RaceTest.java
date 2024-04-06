package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RaceTest {

  private static final String NAME = "David";

  Driver driver1 = new Driver("Daniel", "Sweden");

  Driver driver2 = new Driver("Tomas", "England");

  private Driver driver3 = new AutoPilot("1.0", "Ferrari");

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

  @Test
  void onAutopilotCar() {
    Race race = new Race("Ferrari", driver3);
    assertEquals("Latest Ferrari of model 1.0", race.getDriversName(new AutoPilot("1.0", "Ferrari")));
  }


  @Test
  void onDriverIsLast() {
    Race race = new Race("Jakob", driver1, driver2, driver3);

    assertEquals(2, race.getPosition(driver3));
  }
}
