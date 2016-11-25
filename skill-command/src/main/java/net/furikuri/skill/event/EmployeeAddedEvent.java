package net.furikuri.skill.event;

import java.io.Serializable;

public class EmployeeAddedEvent implements Serializable {
  private String id;
  private String name;

  public EmployeeAddedEvent() {
  }

  public EmployeeAddedEvent(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
