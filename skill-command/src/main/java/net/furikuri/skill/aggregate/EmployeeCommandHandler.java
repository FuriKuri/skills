package net.furikuri.skill.aggregate;

import net.furikuri.skill.command.AddEmployeeCommand;
import net.furikuri.skill.command.AddSkillCommand;
import net.furikuri.skill.command.DeleteSkillCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.AggregateNotFoundException;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCommandHandler {

  @Autowired
  private Repository<EmployeeAggregate> employeeRepository;

  @CommandHandler
  public void create(AddEmployeeCommand command) {
    try {
      EmployeeAggregate employee = employeeRepository.load(command.getId());
      employee.updateName(command.getFirstName(), command.getLastName());
    } catch (AggregateNotFoundException e) {
      EmployeeAggregate employee = new EmployeeAggregate(command.getId(), command.getFirstName(), command.getLastName());
      employeeRepository.add(employee);
    }
  }

  @CommandHandler
  public void addSkill(AddSkillCommand command) {
    EmployeeAggregate employee = employeeRepository.load(command.getEmployeeId());
    employee.addSkill(command.getSkill());
  }

  @CommandHandler
  public void deleteSkill(DeleteSkillCommand command) {
    EmployeeAggregate employee = employeeRepository.load(command.getEmployeeId());
    employee.deleteSkill(command.getSkill());
  }
}
