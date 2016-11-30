package net.furikuri.skill.event;

import java.io.Serializable;

public class SkillAddedEvent implements Serializable {
  private String employeeId;
  private String skill;

  public SkillAddedEvent() {
  }

  public SkillAddedEvent(String employeeId, String skill) {
    this.employeeId = employeeId;
    this.skill = skill;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getSkill() {
    return skill;
  }
}
