package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AppTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  private final String[] args = new String[]{"hi"};

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void onInit() {
    assertNotNull(new App());
  }

  @Test
  void onMain() {
    App.main(args);
    assertEquals("Hello World!", outContent.toString());
  }
}
