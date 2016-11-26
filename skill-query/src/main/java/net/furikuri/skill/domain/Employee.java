package net.furikuri.skill.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.HashSet;
import java.util.Set;

@Document(indexName = "employee", type = "employee", shards = 1, replicas = 0, refreshInterval = "-1")
public class Employee {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private Set<String> skills;

  public Employee() {
  }

  public Employee(String id, String firstName, String lastName, Set<String> skills) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.skills = skills;
  }

  public Employee(String id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<String> getSkills() {
    if (skills == null) {
      skills = new HashSet<>();
    }
    return skills;
  }

  public void setSkills(Set<String> skills) {
    this.skills = skills;
  }

  public void addSkill(String skill) {
    getSkills().add(skill);
  }

  public void removeSkill(String skill) {
    getSkills().remove(skill);
  }
}
