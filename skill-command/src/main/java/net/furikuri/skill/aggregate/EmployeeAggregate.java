package net.furikuri.skill.aggregate;

import net.furikuri.skill.command.AddEmployeeCommand;
import net.furikuri.skill.command.AddSkillCommand;
import net.furikuri.skill.command.DeleteSkillCommand;
import net.furikuri.skill.event.EmployeeAddedEvent;
import net.furikuri.skill.event.SkillAddedEvent;
import net.furikuri.skill.event.SkillDeletedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
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

  @CommandHandler
  public EmployeeAggregate(AddEmployeeCommand command) {
    apply(new EmployeeAddedEvent(command.getId(), command.getFirstName(), command.getLastName()));
  }

  @CommandHandler
  public void addSkill(AddSkillCommand command) {
    apply(new SkillAddedEvent(command.getEmployeeId(), command.getSkill()));
  }

  @CommandHandler
  public void deleteSkill(DeleteSkillCommand command) {
    apply(new SkillDeletedEvent(command.getEmployeeId(), command.getSkill()));
  }

  @EventSourcingHandler
  public void on(EmployeeAddedEvent event) {
    this.id = event.getId();
    this.firstName = event.getFirstName();
    this.lastName = event.getLastName();
  }

  @EventSourcingHandler
  public void on(AddSkillCommand event) {
    skills.add(event.getSkill());
  }

  @EventSourcingHandler
  public void on(DeleteSkillCommand event) {
    skills.add(event.getSkill());
  }
}
