package net.furikuri.skill.event;

import java.io.Serializable;

public class SkillDeletedEvent implements Serializable {
  private String employeeId;
  private String name;

  public SkillDeletedEvent() {
  }

  public SkillDeletedEvent(String employeeId, String name) {
    this.employeeId = employeeId;
    this.name = name;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getName() {
    return name;
  }
}
