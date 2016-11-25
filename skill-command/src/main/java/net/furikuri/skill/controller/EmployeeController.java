package net.furikuri.skill.controller;

import net.furikuri.skill.command.AddEmployeeCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  @Autowired
  private CommandGateway commandGateway;

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  String createEmployee(@PathVariable(name = "id") String id, Employee employee) {
    commandGateway.send(new AddEmployeeCommand(id, employee.firstName, employee.lastName));
    return "ok";
  }
}
