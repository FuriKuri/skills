package net.furikuri.skill.aggregate;

import net.furikuri.skill.command.AddEmployeeCommand;
import net.furikuri.skill.command.AddSkillCommand;
import net.furikuri.skill.event.EmployeeAddedEvent;
import net.furikuri.skill.event.SkillAddedEvent;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

public class EmployeeAggreate extends AbstractAnnotatedAggregateRoot {
  @AggregateIdentifier
  private String id;
  private String name;

  public EmployeeAggreate() {
  }

  @CommandHandler
  public EmployeeAggreate(AddEmployeeCommand command) {
    apply(new EmployeeAddedEvent(command.getId(), command.getName()));
  }

  @CommandHandler
  public void addSkill(AddSkillCommand command) {
    apply(new SkillAddedEvent(command.getId(), command.getSkill()));
  }

  @EventSourcingHandler
  public void on(EmployeeAddedEvent event) {
    this.id = event.getId();
    this.name = event.getName();
  }

  @EventSourcingHandler
  public void on(AddSkillCommand event) {
    this.id = event.getId();
    this.name = event.getSkill();
  }

}
