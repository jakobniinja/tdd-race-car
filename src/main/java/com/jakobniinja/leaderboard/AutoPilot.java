package com.jakobniinja.leaderboard;

public class AutoPilot extends Driver {


  private String version;

  public AutoPilot(String version, String company) {
    super(version, company);
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
