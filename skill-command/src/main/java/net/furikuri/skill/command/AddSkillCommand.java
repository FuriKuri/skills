package net.furikuri.skill.command;


import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class AddSkillCommand {

  @TargetAggregateIdentifier
  private final String employeeId;
  private final String skill;

  public AddSkillCommand(String employeeId, String skill) {
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
