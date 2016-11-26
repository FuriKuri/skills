package net.furikuri.skill.event;

import java.io.Serializable;

public class EmployeeAddedEvent implements Serializable {
  private String id;
  private String firstName;
  private String lastName;

  public EmployeeAddedEvent() {
  }

  public EmployeeAddedEvent(String id, String firstName, String lastName) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
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
