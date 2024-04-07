package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RaceTest {

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


  @Test
  void onGetPointsInit1() {
    Race race = new Race("Jakob", driver1);
    assertEquals(1, race.getPoints(driver1));
  }

  @Test
  void onGetPointsInit2() {
    Race race = new Race("Jakob", driver1, driver2, driver3);
    assertEquals(2, race.getPoints(driver2));
  }

  @Test
  void onGetPointsInit4() {
    Race race = new Race("Jakob", driver1, driver2, driver3);
    assertEquals(4, race.getPoints(driver3));
  }


  @Test
  void onGetPointsInitNull() {
    Race race = new Race("Jakob", driver1, driver2, driver3);
    ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> race.getPoints(new Driver("Yaro", "Kroatien")));

    assertEquals("Index -1 out of bounds for length 3", exception.getMessage());
    assertEquals(null, exception.getCause());
  }
}
