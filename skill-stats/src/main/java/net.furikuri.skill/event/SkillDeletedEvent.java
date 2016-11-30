package net.furikuri.skill.event;

import java.io.Serializable;

public class SkillDeletedEvent implements Serializable {
  private String employeeId;
  private String skill;

  public SkillDeletedEvent() {
  }

  public SkillDeletedEvent(String employeeId, String skill) {
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
