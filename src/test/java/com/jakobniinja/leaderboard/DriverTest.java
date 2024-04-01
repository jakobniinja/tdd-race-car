package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DriverTest {

  private static final String DRIVER = "Best Formula 1 driver";

  private static final String NAME = "William";

  private static final String SWEDEN = "Sweden";

  private Driver driver;

  @BeforeEach
  void setUp() {
    driver = new Driver(NAME, SWEDEN);
  }

  @Test
  void onNotNull() {
    assertNotNull(driver);
  }

  @Test
  void onTwoArguments() {
    driver = new Driver(NAME, SWEDEN);

    assertEquals(NAME, driver.getName());
    assertEquals(SWEDEN, driver.getCountry());
  }
}
