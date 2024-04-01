package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


public class AppTest {

  @Test
  void onInit() {
    assertNotNull(new App());
  }
}
