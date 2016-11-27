package net.furikuri.skill.aggregate;

import net.furikuri.skill.event.EmployeeAddedEvent;
import net.furikuri.skill.event.NameChangedEvent;
import net.furikuri.skill.event.SkillDeletedEvent;
import net.furikuri.skill.event.SkillAddedEvent;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import java.util.HashSet;
import java.util.Set;

public class EmployeeAggregate extends AbstractAnnotatedAggregateRoot {
  @AggregateIdentifier
  private String id;
  private String firstName;
  private String lastName;
  private Set<String> skills = new HashSet<>();

  public EmployeeAggregate() {
  }

  EmployeeAggregate(String id, String firstName, String lastName) {
    apply(new EmployeeAddedEvent(id, firstName, lastName));
  }

  public void addSkill(String skill) {
    apply(new SkillAddedEvent(id, skill));
  }

  public void deleteSkill(String skill) {
    apply(new SkillDeletedEvent(id, skill));
  }

  public void updateName(String firstName, String lastName) {
    apply(new NameChangedEvent(id, firstName, lastName));
  }

  @EventSourcingHandler
  public void on(EmployeeAddedEvent event) {
    this.id = event.getId();
    this.firstName = event.getFirstName();
    this.lastName = event.getLastName();
  }

  @EventSourcingHandler
  public void on(SkillAddedEvent event) {
    skills.add(event.getSkill());
  }

  @EventSourcingHandler
  public void on(SkillDeletedEvent event) {
    skills.remove(event.getSkill());
  }

  @EventSourcingHandler
  public void on(NameChangedEvent event) {
    this.firstName = event.getFirstName();
    this.lastName = event.getLastName();
  }
}
