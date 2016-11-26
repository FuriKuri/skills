package net.furikuri.skill.handler;


import net.furikuri.skill.domain.Employee;
import net.furikuri.skill.event.EmployeeAddedEvent;
import net.furikuri.skill.event.NameChangedEvent;
import net.furikuri.skill.event.SkillAddedEvent;
import net.furikuri.skill.event.SkillDeletedEvent;
import net.furikuri.skill.repository.EmployeeRepository;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventhandling.replay.ReplayAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventHandler implements ReplayAware {
  private static final Logger LOG = LoggerFactory.getLogger(EmployeeEventHandler.class);

  @Autowired
  private EmployeeRepository repository;

  @EventHandler
  public void handle(EmployeeAddedEvent event) {
    repository.save(new Employee(event.getId(), event.getFirstName(), event.getLastName()));
  }

  @EventHandler
  public void handle(SkillAddedEvent event) {
    Employee employee = repository.findOne(event.getEmployeeId());
    employee.addSkill(event.getSkill());
    repository.save(employee);
  }

  @EventHandler
  public void handle(SkillDeletedEvent event) {
    Employee employee = repository.findOne(event.getEmployeeId());
    employee.removeSkill(event.getSkill());
    repository.save(employee);
  }

  @EventHandler
  public void handle(NameChangedEvent event) {
    Employee employee = repository.findOne(event.getEmployeeId());
    employee.setFirstName(event.getFirstName());
    employee.setFirstName(event.getLastName());
    repository.save(employee);
  }

  @Override
  public void beforeReplay() {
    LOG.info("Event Replay is about to START. Clearing the View...");
  }

  @Override
  public void afterReplay() {
    LOG.info("Event Replay has FINISHED.");
  }

  @Override
  public void onReplayFailed(Throwable cause) {
    LOG.error("Event Replay has FAILED.");
  }
}
