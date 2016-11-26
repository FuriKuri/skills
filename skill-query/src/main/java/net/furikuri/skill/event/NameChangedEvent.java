package net.furikuri.skill.event;

public class NameChangedEvent {
  private String employeeId;
  private String firstName;
  private String lastName;

  public NameChangedEvent() {
  }

  public NameChangedEvent(String employeeId, String firstName, String lastName) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
