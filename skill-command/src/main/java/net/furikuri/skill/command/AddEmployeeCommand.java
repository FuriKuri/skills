package net.furikuri.skill.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;


public class AddEmployeeCommand {
  @TargetAggregateIdentifier
  private final String id;
  private final String name;

  public AddEmployeeCommand(String id, String name) {
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
