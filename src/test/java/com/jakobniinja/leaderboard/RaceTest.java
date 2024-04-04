package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RaceTest {

  Driver driver1 = new Driver("Daniel", "Sweden");

  Driver driver2 = new Driver("Tomas", "England");

  @Test
  void onInit() {
    Race race = new Race("David", driver1, driver2);

    assertFalse(race.getResults().isEmpty());
  }

  @Test
  void onGetName(){
    Race race = new Race("David", driver1, driver2);
    assertEquals("David", race.toString());
  }
}
