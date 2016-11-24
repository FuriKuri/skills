package net.furikuri.skill.command;


import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class AddSkillCommand {

  @TargetAggregateIdentifier
  private final String id;
  private final String skill;

  public AddSkillCommand(String id, String skill) {
    this.id = id;
    this.skill = skill;
  }

  public String getId() {
    return id;
  }

  public String getSkill() {
    return skill;
  }

}
