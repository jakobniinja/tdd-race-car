package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {

  private static final String NAME = "David";

  private final Driver driver1 = new Driver("Daniel", "Sweden");

  private final Driver driver2 = new Driver("Tomas", "England");

  private final Driver driver3 = new AutoPilot("1.0", "Ferrari");

  private Race race;

  @BeforeEach
  void setUp() {
    race = new Race(NAME, driver1, driver2, driver3);
  }

  @Test
  void onInit() {
    assertFalse(race.getResults().isEmpty());
  }

  @Test
  void onGetName() {
    assertEquals(NAME, race.toString());
  }

  @Test
  void onInitDriverNameNull() {
    assertNull(race.getDriversName(new Driver(NAME, "Sweden")));
  }

  @Test
  void onDriverNameDaniel() {
    assertEquals("Daniel", race.getDriversName(new Driver("Daniel", "Sweden")));
  }

  @Test
  void onAutopilotCar() {
    assertEquals("Latest Ferrari of model 1.0", race.getDriversName(new AutoPilot("1.0", "Ferrari")));
  }


  @Test
  void onDriverIsLast() {
    assertEquals(2, race.getPosition(driver3));
  }


  @Test
  void onGetPointsInit1() {
    Race race = new Race("Jakob", driver1);
    assertEquals(1, race.getPoints(driver1));
  }

  @Test
  void onGetPointsInit2() {
    assertEquals(2, race.getPoints(driver2));
  }

  @Test
  void onGetPointsInit4() {
    assertEquals(4, race.getPoints(driver3));
  }


  @Test
  void onGetPointsInitNull() {
    Driver driver = new Driver("Yaro", "Kroatien");
    ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> race.getPoints(driver));

    assertEquals("Index -1 out of bounds for length 3", exception.getMessage());
    assertNull(exception.getCause());
  }
}
