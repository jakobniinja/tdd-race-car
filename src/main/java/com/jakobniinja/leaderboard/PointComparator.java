package com.jakobniinja.leaderboard;

import java.util.Comparator;
import java.util.Map;

public class PointComparator implements Comparator<Integer> {

  public Map<String,Integer> results;

  public PointComparator(Map<String, Integer> results) {
    this.results = results;
  }

  @Override
  public int compare(Integer o1, Integer o2) {
    return o2.compareTo(o1);
  }
}
