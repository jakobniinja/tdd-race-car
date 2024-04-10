package com.jakobniinja.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PointComparatorTest {

  @Test
  void onInitNotNull() {
    Map<String, Integer> results = new HashMap<>();

    assertNotNull(new PointComparator(results));
  }

  @Test
  void onNotEmpty() {
    Map<String, Integer> results = new HashMap<>();

    results.put("John", 150);

    PointComparator pointComparator = new PointComparator(results);
    assertNotNull(pointComparator);
    assertFalse(pointComparator.results.isEmpty());

  }

  @Test
  void onPointSortingHighestFirst() {
    Map<String, Integer> results = new HashMap<>();

    results.put("John", 150);
    results.put("Dan", 10);
    results.put("Emilia", 210);

    PointComparator pointComparator = new PointComparator(results);
    List<Integer> list = new ArrayList<>(results.values());

    list.sort(new PointComparator(results));
    assertFalse(pointComparator.results.isEmpty());
    assertEquals(210, list.get(0).intValue());
    assertEquals(10, list.get(2).intValue());

  }

  @Test
  void onCompareHigh() {
    Map<String, Integer> results = new HashMap<>();

    PointComparator pointComparator = new PointComparator(results);
    assertEquals(-1, pointComparator.compare(3, 1));
  }


  @Test
  void onCompareLow() {
    Map<String, Integer> results = new HashMap<>();

    PointComparator pointComparator = new PointComparator(results);
    assertEquals(1, pointComparator.compare(3, 5));
  }
}
