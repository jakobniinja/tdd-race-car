package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NameComparatorTest {

  @Test
  void onInitNotNull() {
    Map<String, Integer> results = new HashMap<>();
    assertNotNull(new NameComparator(results));
  }

  @Test
  void onInitEmpty() {
    Map<String, Integer> results = new HashMap<>();
    NameComparator nameComparator = new NameComparator(results);

    assertNotNull(nameComparator);
    assertTrue(nameComparator.results.isEmpty());
  }

  @Test
  void onTestCompareGreater() {

    NameComparator nameComparator = new NameComparator(new HashMap<>());

    assertTrue(nameComparator.results.isEmpty());
    assertEquals(1, nameComparator.compare("B", "A"));
  }


  @Test
  void onTestCompareSmaller() {

    NameComparator nameComparator = new NameComparator(new HashMap<>());

    assertTrue(nameComparator.results.isEmpty());
    assertEquals(-1, nameComparator.compare("A", "B"));
  }
}
