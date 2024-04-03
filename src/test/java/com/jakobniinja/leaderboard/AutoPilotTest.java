package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoPilotTest {


  private AutoPilot autoPilot;

  @BeforeEach
  void setUp() {
    autoPilot = new AutoPilot("1.0", "Ferrari");
  }

  @Test
  void onInit() {
    assertNotNull(autoPilot);
  }

  @Test
  void onGetVersion() {
    assertEquals("1.0", autoPilot.getVersion());
  }

  @Test
  void onSetVersion() {
    autoPilot.setVersion("1.1");
    assertEquals("1.1", autoPilot.getVersion());
  }
}
