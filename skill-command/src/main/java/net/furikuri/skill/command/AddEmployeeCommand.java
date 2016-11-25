package net.furikuri.skill.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;


public class AddEmployeeCommand {
  @TargetAggregateIdentifier
  private final String id;
  private final String firstName;
  private final String lastName;

  public AddEmployeeCommand(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
