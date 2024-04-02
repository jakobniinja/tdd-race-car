package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.print.attribute.standard.MediaSize.NA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DriverTest {

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

  @Test
  void onHashcodeWilliam() {
    assertEquals(1388422473, driver.hashCode());
  }

  @Test
  void onEqualsSame() {
    assertEquals(driver, driver);
  }

  @Test
  void onEqualsNull(){
    assertNotEquals(null, driver);
  }

  @Test
  void onEqualsOtherInstance(){
    String secondDriver = "Jakob";
    assertNotEquals(driver, secondDriver);
  }

  @Test
  void onEqualsName(){
    Driver other = new Driver(NAME, "German");
    assertNotEquals(driver, other);
  }


  @Test
  void onEqualsCountry(){
    Driver other = new Driver("Daniel", "Sweden");
    assertNotEquals(driver, other);
  }


  @Test
  void onMatchNameCountry(){
    Driver other = new Driver(NAME, "Sweden");
    assertEquals(driver, other);
  }
}
