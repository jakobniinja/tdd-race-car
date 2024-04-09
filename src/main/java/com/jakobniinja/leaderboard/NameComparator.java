package com.jakobniinja.leaderboard;

import java.util.Comparator;
import java.util.Map;

public class NameComparator implements Comparator<String> {

  Map<String, Integer> results;

  public NameComparator(Map<String, Integer> results) {
    this.results = results;
  }

  @Override
  public int compare(String o1, String o2) {
    return o1.compareTo(o2);
  }
}
